package S2_programs;

import javax.swing.*;
import java.awt.*;

public class Histogram extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new Histogram();
        frame.setSize(700,700);
        frame.setTitle("S2_programs.Histogram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Histogram() { add(new DrawPanel()); }

    class DrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(50, 20, 300, 300);
            for (int i = 0; i < 10; i++) {

                //Vertical
                g.drawString("" + (i+1), 10 , 290-i*30);
                g.drawLine(45, 290-i*30, 55, 290-i*30);

                //Horizontal
                g.drawString(""+(i+1), 80+i*30, 350);
                g.drawLine(80+i*30, 325, 80+i*30, 315);
            }

            Color rectColor = Color.RED; // You can change the color
            g.setColor(rectColor);
            g.drawRect(52, 260, 26, 60);
            g.drawRect(82, 230, 26, 90);
            g.drawRect(112, 80, 26, 240);
            g.drawRect(142, 260, 26, 60);
            g.drawRect(172, 290, 26, 30);
            g.drawRect(232, 230, 26, 90);
            g.drawRect(292, 140, 26, 180);
            g.drawRect(322, 230, 26, 90);
        }
    }
}
