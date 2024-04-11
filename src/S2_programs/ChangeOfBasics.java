package S2_programs;

import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;

public class ChangeOfBasics extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new ChangeOfBasics();
        frame.setSize(700,700);
        frame.setTitle("Change Of Basics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ChangeOfBasics() { add(new DrawPanel()); }


    class DrawPanel extends JPanel {
        S2 s = new S2(50, 50, 120, 300);
        V2 P = new V2(5, 3);
        S2 sm = new S2(50, 50, 120, 300, 2, 2);
        V2 pm = new V2(2*Math.sqrt(2), -Math.sqrt(2));

        DrawPanel(){
            sm.rotate(Math.PI/4);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            s.drawAxis(g, 5, 5, true, Color.RED);
            s.drawPoint(g, P, Color.BLACK, 10);
            sm.drawAxis(g, 3, 3, true, Color.BLUE);
            sm.drawPoint(g, pm, Color.GREEN, 10);
            s.drawPoint(g, new V2(1, 1));
            s.drawPoint(g, new V2(1, 2), Color.RED);
            s.drawPoint(g, new V2(2, 1), Color.BLUE, 10);
        }
    }
}
