package S3_Programs;

import Importers.WavefrontImporter;
import Mathematical_Engine.Camera;
import Mathematical_Engine.M3;
import Mathematical_Engine.V3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class ImportProgram extends JFrame {
    public static void main(String[] args) {
        ImportProgram frame=new ImportProgram();
        frame.setTitle("Importer");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    ImportProgram() {
        add(new PaintPanel());
    }

    class PaintPanel extends JPanel {
        int counter = 0;
        TimerListener timer = new TimerListener(counter);
        FPSCounter fpsCounter = new FPSCounter();
        Timer myTimer = new Timer(20, timer);  // Timer updates every 50 ms
        Timer fpsTimer = new Timer(1000, fpsCounter);
        Camera cam = new Camera(100, 100, 500, 400);
        WavefrontImporter wf = new WavefrontImporter("src/Files/Eiffel_Tower.obj");



        PaintPanel() {
            myTimer.start();
            fpsTimer.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Counter = " + fpsCounter.counter, 10, 10);
            //cam.moveTo(new V3(200,100,100));
            cam.moveTo(new V3(10,5,2));
            wf.draw(g, cam);
            cam.focus(wf.getCenter());
            cam.zoom(10);
            cam.drawAxis(g);
        }

        class TimerListener implements ActionListener {
            int counter;

            public TimerListener(int counter) {
                this.counter = counter;
            }

            public void actionPerformed(ActionEvent evt) {
                repaint();
                counter++;
            }
        }

        class FPSCounter implements ActionListener {
            int counter;

            public void actionPerformed(ActionEvent evt) {
                counter = timer.counter;
                timer.counter = 0;
            }
        }
    }
}
