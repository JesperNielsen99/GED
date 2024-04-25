package Importers;

import Mathematical_Engine.Camera;
import Mathematical_Engine.V3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class WavefrontImporter {
    ArrayList<V3> vectors;
    ArrayList<ArrayList<Integer>> faces;
    ArrayList<ArrayList<Integer>> lines;
    Scanner scanner;

    public WavefrontImporter(String filePath) {
        vectors = new ArrayList<>();
        faces = new ArrayList<>();
        lines = new ArrayList<>();
        extractData(filePath);
    }

    public void draw(Graphics g, Camera camera) {
        for (ArrayList<Integer> face : faces) {
            camera.drawLine(g, vectors.get(face.get(0) - 1), vectors.get(face.get(1) - 1));
            camera.drawLine(g, vectors.get(face.get(1) - 1), vectors.get(face.get(2) - 1));
            camera.drawLine(g, vectors.get(face.get(2) - 1), vectors.get(face.get(0) - 1));
        }
        for (ArrayList<Integer> line : lines) {
            camera.drawLine(g, vectors.get(line.get(0) - 1), vectors.get(line.get(1) - 1));
        }
    }

    private void extractData(String filePath) {
        try {
            File file = new File(filePath);
            scanner = new Scanner(file).useLocale(Locale.US);
            ArrayList<String> rawData = new ArrayList<>();
            while (scanner.hasNextLine()) {
                rawData.add(scanner.nextLine());
            }
            scanner.close();
            setupData(rawData);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void setupData(ArrayList<String> rawData) {
        if (!rawData.isEmpty()) {
            for (String data : rawData) {
                String[] lines = data.split("\\s+");
                if (lines[0].equals("v")) {
                    double x = Double.valueOf(lines[1]);
                    double z = Double.valueOf(lines[2]);
                    double y = Double.valueOf(lines[3]);
                    V3 v3 = new V3(x, y, z);
                    vectors.add(v3);
                } else if (lines[0].equals("l")) {
                    ArrayList<Integer> vectors = new ArrayList<>();
                    for (String string : lines) {
                        if (!string.isEmpty() && !string.equals("l") && !string.equals("#")) {
                            String[] vector = string.split("/");
                            for (String vector0 : vector) {
                                int v1 = Integer.valueOf(vector[0]);
                                vectors.add(v1);
                            }
                        }
                    }
                    this.lines.add(vectors);
                    vectors = new ArrayList<>();
                } else if (lines[0].equals("f")) {
                    ArrayList<Integer> vectors = new ArrayList<>();
                    for (String string : lines) {
                        if (!string.isEmpty() && !string.equals("f")) {
                            String[] vector = string.split("/");
                            for (String vector0 : vector) {
                                int v1 = Integer.valueOf(vector[0]);
                                vectors.add(v1);
                            }
                        }
                    }
                    this.faces.add(vectors);
                    vectors = new ArrayList<>();
                }
            }

        }
    }
    public V3 getCenter() {
        V3 newVector = new V3(0, 0, 0);
        for (V3 vector : vectors) {
            newVector.add(vector);
        }
        return newVector.div(vectors.size());
    }
}
