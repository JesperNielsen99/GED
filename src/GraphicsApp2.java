import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;

public class GraphicsApp2 extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new GraphicsApp2();
        frame.setSize(700,700);
        frame.setTitle("GraphicsApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public GraphicsApp2() {
        add(new DrawPanel());
    }
    S2 s = new S2(50, 50, 120, 300);

    class DrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            V2 test1 = new V2(1,2);
            s.drawLine(g, new V2(0,0), test1, Color.BLACK);
            s.drawAxis(g, 5, 5, true, Color.red);
            s.drawPoint(g, new V2(4,2), 10, Color.BLACK);
            s.drawRect(g, new V2(0,0), new V2(2,4), Color.BLUE);
        }
    }
}
