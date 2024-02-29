import Mathematical_Engine.M2;
import Mathematical_Engine.S2;
import Mathematical_Engine.V2;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class TwoD_Transformation extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new TwoD_Transformation();
        frame.setSize(700,700);
        frame.setTitle("2D Transformation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public TwoD_Transformation() { add(new DrawPanel()); }

    S2 s = new S2(50, 50, 120, 300);

    class DrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            s.drawAxis(g, 5, 5, true, Color.RED);

            /*
            //Move Triangle
            V2 TA = new V2(2, 2);
            V2 TB = new V2(3, 4);
            V2 TC = new V2(4, 2);
            V2 TV = new V2(-1, 1);
            s.drawLine(g, TA, TB, Color.BLACK);
            s.drawLine(g, TB, TC, Color.BLACK);
            s.drawLine(g, TC, TA, Color.BLACK);
            V2 TAm = TA.sub(TV);
            V2 TBm = TB.sub(TV);
            V2 TCm = TC.sub(TV);
            s.drawLine(g, TAm, TBm, Color.BLUE);
            s.drawLine(g, TBm, TCm, Color.BLUE);
            s.drawLine(g, TCm, TAm, Color.BLUE);
             */





            //Rotate Square
            /*
            V2 SA = new V2(2,2);
            V2 SB = new V2(4,2);
            V2 SC = new V2(4,4);
            V2 SD = new V2(2,4);
            V2[] vectors = {SA, SB, SC, SD};
            V2 SP = new V2(vectors);
            System.out.println(SP);
            s.drawLine(g, SA, SB, Color.BLACK);
            s.drawLine(g, SB, SC, Color.BLACK);
            s.drawLine(g, SC, SD, Color.BLACK);
            s.drawLine(g, SD, SA, Color.BLACK);
            s.drawPoint(g, SP, 3, Color.BLACK);
            double phi = PI/3;
            M2 rotationMatrix = new M2(phi);
            V2 SAm = rotationMatrix.rotate(SA, SP);
            V2 SBm = rotationMatrix.rotate(SB, SP);
            V2 SCm = rotationMatrix.rotate(SC, SP);
            V2 SDm = rotationMatrix.rotate(SD, SP);
            s.drawLine(g, SAm, SBm, Color.GREEN);
            s.drawLine(g, SBm, SCm, Color.GREEN);
            s.drawLine(g, SCm, SDm, Color.GREEN);
            s.drawLine(g, SDm, SAm, Color.GREEN);
            */

            //Reflect Triangle
            /*
            V2 TRA = new V2(2, 2);
            V2 TRB = new V2(3, 4);
            V2 TRC = new V2(4, 2);
            s.drawLine(g, TRA, TRB, Color.BLACK);
            s.drawLine(g, TRB, TRC, Color.BLACK);
            s.drawLine(g, TRC, TRA, Color.BLACK);
            M2 reflection = new M2(1, 0, 0, -1);
            V2 TRAm = reflection.mul(TRA);
            V2 TRBm = reflection.mul(TRB);
            V2 TRCm = reflection.mul(TRC);
            s.drawLine(g, TRAm, TRBm, Color.BLUE);
            s.drawLine(g, TRBm, TRCm, Color.BLUE);
            s.drawLine(g, TRCm, TRAm, Color.BLUE);
            V2 temp = new V2(0, 3*2);
            V2 TRAmm = TRAm.add(temp);
            V2 TRBmm = TRBm.add(temp);
            V2 TRCmm = TRCm.add(temp);
            s.drawLine(g, TRAmm, TRBmm, Color.GREEN);
            s.drawLine(g, TRBmm, TRCmm, Color.GREEN);
            s.drawLine(g, TRCmm, TRAmm, Color.GREEN);
            */


            //Stretch Circle
            /*
            V2 C = new V2(2,2);
            int r = 1;
            int a = 2;
            double b = 0.5;
            for (double v =0; v<2* Math.PI; v+=0.01) {                          //vinkel er parameter
                V2 c = C.add(new V2(r*Math.cos(v), r*Math.sin(v)));    //punkter på ellipse
                s.drawPoint(g, c, 3, Color.BLACK);
                V2 p = C.add(new V2(a* Math.cos(v), b* Math.sin(v)));    //punkter på ellipse
                s.drawPoint(g, p, 3, Color.BLUE);
            }
            */

            //Skew Square
            V2 SSA = new V2(2,2);
            V2 SSB = new V2(4,2);
            V2 SSC = new V2(4,4);
            V2 SSD = new V2(2,4);
            double d = 0.5;
            s.drawLine(g, SSA, SSB, Color.BLACK);
            s.drawLine(g, SSB, SSC, Color.BLACK);
            s.drawLine(g, SSC, SSD, Color.BLACK);
            s.drawLine(g, SSD, SSA, Color.BLACK);
            M2 rotationMatrix = new M2(1, d, 0, 1);
            V2 SSAm = rotationMatrix.rotate(SSA, SSA);
            V2 SSBm = rotationMatrix.rotate(SSB, SSA);
            V2 SSCm = rotationMatrix.rotate(SSC, SSA);
            V2 SSDm = rotationMatrix.rotate(SSD, SSA);
            s.drawLine(g, SSAm, SSBm, Color.GREEN);
            s.drawLine(g, SSBm, SSCm, Color.GREEN);
            s.drawLine(g, SSCm, SSDm, Color.GREEN);
            s.drawLine(g, SSDm, SSAm, Color.GREEN);

        }
    }
}
