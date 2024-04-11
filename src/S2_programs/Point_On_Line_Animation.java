package S2_programs;

import Mathematical_Engine.V2;
import Mathematical_Engine.S2;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.Timer;

public class Point_On_Line_Animation extends JFrame {
    public static void main(String[] args) {
        Point_On_Line_Animation frame=new Point_On_Line_Animation();
        frame.setTitle("Animation_Point_On_Line");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } // main()

    Point_On_Line_Animation() {
        add(new PaintPanel());
    }

    class PaintPanel extends JPanel {
        S2 S2=new S2(40,40,100,500);

        // Simulating time
        double t0;                       // Timestamp of simulation start in sec
        double t=0;                      // Time in sec since simulation start

        // S2_programs.Animation
        int frameRate=25;                // No of frames/second
        int frameDelay = 1000/frameRate; // time between frames in milli sec
        Timer myTimer=new Timer(frameDelay, new TimerListener());

        V2 A=new V2(4,2);       // Fixed point on the line
        V2 B=new V2(16,5);      // Fixed point on the line
        V2 r=B.sub(A).unit();   // Unit length vector in direction of the line
        V2 P;                   // Blue point moving along the line
        double s=2;             // speed - units pr. sec

        PaintPanel() {
            // Start simulation
            t0=System.currentTimeMillis()/1000.0;
            myTimer.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Update time
            t=System.currentTimeMillis()/1000.0-t0;

            // Simulation
            P=A.add(r.mul(s*t));

            // Display
            S2.drawAxis(g);
            S2.drawLine(g, A, B);
            S2.drawPoint(g, A, Color.BLACK, 10);
            S2.drawPoint(g, B, Color.BLACK, 10);
            S2.drawPoint(g, P, Color.BLUE, 10);

            // Stop simulation
            if (P.x>=B.x) myTimer.stop();
        }

        class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent evt){
                repaint();
            }
        }
    } // class PaintPanel

} // class MainFrame
