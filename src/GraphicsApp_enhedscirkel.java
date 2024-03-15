import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;

public class GraphicsApp_enhedscirkel extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new GraphicsApp_enhedscirkel();
        frame.setSize(700,700);
        frame.setTitle("GraphicsApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public GraphicsApp_enhedscirkel() {
        add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        S2 s = new S2(50, 50, 120, 300);
        int n = 5;
        V2[] points = new V2[n];

        DrawPanel(){
            double v = 2*Math.PI/n;
            for(int i = 0; i<n; i++) {
                double x = Math.cos(i*v);
                double y = Math.sin(i*v);
                points[i] = new V2(y, x);
            }
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            s.drawAxis(g, 2, 2, false, Color.RED);
            /*for (double v=0; v<2*Math.PI; v+=0.001) {
                double x = Math.cos(v);
                double y = Math.sin(v);
                s.drawPoint(g, new V2(x,y), 2, Color.BLACK);
            }*/
            for(int i=0; i<n; i++) {
                s.drawPoint(g, points[i], Color.BLACK, 3);
                int j = (i+n/2)%n;
                s.drawLine(g, points[i], points[j], Color.BLACK);
            }
        }
    }
}
