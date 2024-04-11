package S3_Programs;

import Mathematical_Engine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class RotateCubeAnimation extends JFrame {
    public static void main(String[] args) {
       RotateCubeAnimation frame=new RotateCubeAnimation();
        frame.setTitle("S2_programs.RotateSquareAnimation");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    RotateCubeAnimation() {
        add(new PaintPanel());
    }

    class PaintPanel extends JPanel {
        int counter = 0;
        TimerListener timer = new TimerListener(counter);
        FPSCounter fpsCounter = new FPSCounter();
        Timer myTimer = new Timer(20, timer);  // Timer updates every 50 ms
        Timer fpsTimer = new Timer(1000, fpsCounter);
        S3 s = new S3(100, 100, 200, 400);
        M3 I = new M3(1,0,0,
                     0,1,0,
                     0,0,1);
        M3 Sz0 = new M3( 0, -1, 0,
                        1, 0, 0,
                        0, 0, 0);

        M3 Sz1 = new M3( 0, 0, 1,
                         0, 0, 0,
                         -1, 0, 0);
        M3 Sz2 = new M3( 0, 0, 0,
                         0, 0, -1,
                         0, 1, 0);
        M3 Sz3 = new M3( 0, -1, 1,
                        1, 0, -1,
                        -1, 1, 0);
        double phi = PI/100;
        M3 Rz0 = I.add(Sz0.mul(sin(phi))).add(Sz0.mul(Sz0).mul(1-cos(phi)));
        M3 Rz1 = I.add(Sz1.mul(sin(phi))).add(Sz1.mul(Sz1).mul(1-cos(phi)));
        M3 Rz2 = I.add(Sz2.mul(sin(phi))).add(Sz2.mul(Sz2).mul(1-cos(phi)));
        M3 Rz3 = I.add(Sz3.mul(sin(phi))).add(Sz3.mul(Sz3).mul(1-cos(phi)));
        V3[] cube= new V3[8];
        V3 C = new V3(0,0,0);



        PaintPanel() {
            myTimer.start();
            fpsTimer.start();
            cube[0]=new V3(1,4,1);
            cube[1]=new V3(1,4,3);
            cube[2]=new V3(1,6,1);
            cube[3]=new V3(1,6,3);
            cube[4]=new V3(3,4,1);
            cube[5]=new V3(3,4,3);
            cube[6]=new V3(3,6,1);
            cube[7]=new V3(3,6,3);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            System.out.println(timer.counter);
            System.out.println(fpsCounter.counter);
            g.drawString("Counter = " + fpsCounter.counter, 10, 10);
            s.drawAxis(g);
            s.drawLine(g, cube[0], cube[1]);
            s.drawLine(g, cube[1], cube[3]);
            s.drawLine(g, cube[3], cube[2]);
            s.drawLine(g, cube[2], cube[0]);
            s.drawLine(g, cube[4], cube[5]);
            s.drawLine(g, cube[5], cube[7]);
            s.drawLine(g, cube[7], cube[6]);
            s.drawLine(g, cube[6], cube[4]);
            s.drawLine(g, cube[0], cube[4]);
            s.drawLine(g, cube[1], cube[5]);
            s.drawLine(g, cube[3], cube[7]);
            s.drawLine(g, cube[2], cube[6]);
            C = new V3(cube);

            for (int i = 0; i < cube.length; i++) {
                //cube[i]=Rz0.mul(cube[i].sub(C)).add(C);
                //cube[i]=Rz1.mul(cube[i].sub(C)).add(C);
                //cube[i]=Rz2.mul(cube[i].sub(C)).add(C);
                cube[i]=Rz3.mul(cube[i].sub(C)).add(C);
            }
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
