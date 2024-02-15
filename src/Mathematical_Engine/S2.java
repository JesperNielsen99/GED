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

    public void drawLine(Graphics g, V2 p1, V2 p2, Color color) {
        V2 pixelValuep1 = transform(p1);
        V2 pixelValuep2 = transform(p2);
        g.setColor(color);
        g.drawLine((int) pixelValuep1.x, (int) pixelValuep1.y, (int) pixelValuep2.x, (int) pixelValuep2.y);
    }

    public void drawString(Graphics g, String text, V2 p1, Color color) {
        V2 pixelValuep1 = transform(p1);
        g.setColor(color);
        g.drawString(text, (int) pixelValuep1.x, (int) pixelValuep1.y);
    }

    public void drawString(Graphics g, String text, V2 p1, Color color, Font font) {
        V2 pixelValuep1 = transform(p1);
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, (int) pixelValuep1.x, (int) pixelValuep1.y);
    }


    public void drawPoint(Graphics g, V2 p1, int diameter, Color color) {
        V2 pixelvaluep1 = transform(p1);
        g.setColor(color);
        g.fillOval((int) (pixelvaluep1.x-0.5*diameter), (int) (pixelvaluep1.y-0.5*diameter), diameter, diameter);
    }

    public void drawGrid(Graphics g, int xLength, int yLength, Color color) {
        g.setColor(Color.lightGray);
        for (int i = 1; i < xLength+1; i++) {
            drawLine(g, new V2(i, 0), new V2(i, yLength), color);
        }
        for (int i = 1; i < yLength+1; i++) {
            drawLine(g, new V2(0, i), new V2(xLength, i), color);
        }
    }

    public void drawRect(Graphics g, V2 p1, V2 p2, Color color) {
        V2 pixelValuep1 = transform(p1);
        V2 pixelValuep2 = transform(p2);
        g.setColor(color);
        g.drawRect((int) pixelValuep1.x, (int) pixelValuep1.y, (int) (pixelValuep2.x-pixelValuep1.x), (int) (pixelValuep2.y- pixelValuep1.y));
    }

    public void drawOval(Graphics g, V2 p1, int width, int height, Color color){
        V2 pixelValuep1 = transform(p1);
        g.setColor(color);
        g.drawOval((int) pixelValuep1.x, (int) pixelValuep1.y, width, height);
    }

    public void drawAxis(Graphics g, int xLength, int yLenght, boolean details , Color color) {
        drawGrid(g, xLength, yLenght, Color.lightGray);
        drawLine(g, origo, new V2(xLength,0), color);
        drawLine(g, origo, new V2(0,yLenght), color);
        Font font = new Font("Arial", Font.BOLD, 18); // You can change the font type, style, and size
        g.setFont(font);
        if (details) {
            for (int i = 0; i < xLength + 1; i++) {
                drawString(g, "" + i, new V2(-0.5, i - 0.15), color, font);
                drawLine(g, new V2(-0.1, i), new V2(0.1, i), color);
                drawString(g, "" + i, new V2(i - 0.07, -0.5), color, font);
                drawLine(g, new V2(i, -0.1), new V2(i, 0.1), color);
            }
        drawString(g,"x", new V2(0, xLength+0.3), color, font);
        drawString(g,"y", new V2(yLenght+0.3, 0), color, font);
        }
    }
}
