package Mathematical_Engine;

import java.awt.*;

public class S2 {
    V2 origo = new V2(0,0);
    V2 O;
    M2 T;

    public S2(int Sx, int Sy, int Ox, int Oy) {
        O = new V2(Ox, Oy);
        M2 S = new M2(Sx, 0 , 0, Sy);
        M2 F = new M2(1, 0, 0,-1);
        T = F.mul(S);
    }

    V2 transform(V2 v) {
        return T.mul(v).add(O);
    }

    public void drawLine(Graphics g, V2 p1, V2 p2) {
        V2 pixelValuep1 = transform(p1);
        V2 pixelValuep2 = transform(p2);
        g.drawLine((int) pixelValuep1.x, (int) pixelValuep1.y, (int) pixelValuep2.x, (int) pixelValuep2.y);
    }

    public void drawString(Graphics g, String text, V2 p1) {
        V2 pixelValuep1 = transform(p1);
        g.drawString(text, (int) pixelValuep1.x, (int) pixelValuep1.y);
    }

    public void drawAxis(Graphics g, int xLenght, int yLenght) {
        g.setColor(Color.RED);
        drawLine(g, origo, new V2(xLenght,0));
        drawLine(g, origo, new V2(0,yLenght));
        Font font = new Font("Arial", Font.BOLD, 18); // You can change the font type, style, and size
        g.setFont(font);
        for (int i = 0; i < xLenght+1; i++) {
            drawString(g, ""+i, new V2(-0.3, i));
            drawLine(g, new V2(-0.1, i), new V2(0.1, i));
        }
        drawString(g,"x", new V2(0, xLenght+0.3));
        drawString(g,"y", new V2(yLenght+0.3, 0));
    }
}
