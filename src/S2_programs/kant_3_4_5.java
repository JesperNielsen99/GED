package S2_programs;

import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;

public class kant_3_4_5 extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new kant_3_4_5();
        frame.setSize(700,700);
        frame.setTitle("S2_programs.GraphicsApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public kant_3_4_5() {
        add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        S2 s = new S2(50, 50, 200, 400);

        V2 sideA = new V2(0, 0);
        V2 sideB = new V2(3, sideA.y);
        V2 sideC = new V2(sideB.x, 4);
        double angleA, angleB, angleC;

        DrawPanel(){
            double sideC = Math.sqrt(sideB.length() * sideB.length() + this.sideC.length() * this.sideC.length());
            angleA = Math.toDegrees(Math.asin(sideB.length() / this.sideC.length()));
            angleB = Math.toDegrees(Math.asin(this.sideB.length() / this.sideC.length()));
            angleC = 90;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            s.drawAxis(g, 5, 5, false, Color.RED);
            s.drawLine(g, sideA, new V2(3, 0), Color.BLACK);
            s.drawLine(g, sideB, sideC, Color.BLACK);
            s.drawLine(g, sideC, sideA, Color.BLACK);
            s.drawString(g, "A: " + angleA, new V2(-0.5,-0.3), Color.BLACK);
            s.drawString(g, "B: " + angleB, new V2(2.5,4.1), Color.BLACK);
            s.drawString(g, "C: " + angleC, new V2(3,-0.3), Color.BLACK);
        }
    }
}
