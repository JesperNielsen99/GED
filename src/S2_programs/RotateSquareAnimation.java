package S2_programs;

import Mathematical_Engine.M2;
import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.*;

public class RotateSquareAnimation extends JFrame {
    public static void main(String[] args) {
        RotateSquareAnimation frame=new RotateSquareAnimation();
        frame.setTitle("S2_programs.RotateSquareAnimation");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } // main()

    RotateSquareAnimation() {
        add(new PaintPanel());
    }

    class PaintPanel extends JPanel {
        Timer myTimer=new Timer(50, new TimerListener());  // Timer updates every 50 ms

        S2 S=new S2(50,50, 120,300);
        V2 A=new V2(2,2);
        V2 B=new V2(4,2);
        V2 C=new V2(4,4);
        V2 D=new V2(2,4);
        V2 P=A.add(B).add(C).add(D).mul(1.0/4);     // Rotations punkt
        double phi=PI/100;                          // Rotations vinkel
        M2 M=new M2(cos(phi), -sin(phi),
                sin(phi), cos(phi));

        PaintPanel() {
            myTimer.start();    // Start simulation
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Simulation
            A=M.mul(A.sub(P)).add(P);
            B=M.mul(B.sub(P)).add(P);
            C=M.mul(C.sub(P)).add(P);
            D=M.mul(D.sub(P)).add(P);

            // Display
            S.drawAxis(g);
            S.drawLine(g,A,B);
            S.drawLine(g,B,C);
            S.drawLine(g,C,D);
            S.drawLine(g,D,A);
        }

        class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent evt){
                repaint();
            }
        }
    } // class PaintPanel

} // class MainFrame