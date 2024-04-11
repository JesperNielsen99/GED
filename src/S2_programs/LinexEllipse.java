package S2_programs;

import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;

public class LinexEllipse extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new LinexEllipse();
        frame.setSize(700,700);
        frame.setTitle("S2_programs.LinexEllipse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public LinexEllipse() { add(new DrawPanel()); }

    class DrawPanel extends JPanel {
        S2 s = new S2(50, 50, 75, 550);
        V2 p0 = new V2(4, 3);                                             //Centrum af ellipse
        double a = 3;                                                           //Store Akse
        double b = 2;                                                           //Lille akse
        V2 q0 = new V2(2.5, 0);                                           //Fast punkt på linien (x0,y0)
        double m=2.0/3;                                                         //m er hældningskoefficienten


        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            s.drawAxis(g, 10, 10, true, Color.RED);
            for (double v =0; v<2* Math.PI; v+=0.01) {                          //vinkel er parameter
                V2 p = p0.add(new V2(a* Math.cos(v), b* Math.sin(v)));    //punkter på ellipse
                s.drawPoint(g, p, Color.BLUE, 3);
            }
            for (double k=0; k<5; k+=0.01) {                                    //k er parameter i parameterfremstilling
                V2 q = q0.add(new V2(1, m).mul(k));                          //nye punkter på linien
                s.drawPoint(g, q, Color.BLACK, 3);
            }
        }
    }
}