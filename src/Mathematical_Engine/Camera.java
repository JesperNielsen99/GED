package Mathematical_Engine;

import java.awt.*;

import static java.lang.Math.*;

public class Camera {
    V3 O = new V3(0,0,0); //Virtual world Basis
    V3 i = new V3(1,0,0);
    V3 j = new V3(0,1,0);
    V3 k = new V3(0,0,1);

    V3 E = new V3(0,0,0); //Camera Basis
    V3 D = new V3(1,0,0);
    V3 U = new V3(0,1,0);
    V3 R = new V3(0,0,1);
    double z = 2;

    S2 s2;

    public Camera(int Sx, int Sy, int Ox, int Oy) {
        s2 = new S2(Sx, Sy, Ox, Oy);
    }

    public V2 project(V3 p) {
        V3 EP = p.sub(E);
        double d = D.dot(EP);
        double u = U.dot(EP);
        double r = R.dot(EP);
        double um = u*z/d;
        double rm = r*z/d;
        return new V2(rm, um);
    }

    public void moveTo(V3 p) {
        E = new V3(p.x, p.y, p.z);
    }

    public void focus(V3 p) {
        D = p.sub(E).unit();
        R = D.cross(k).unit();
        U = R.cross(D); // crossing 2 unit vectors gives a unit vector.
    }

    public void zoom(double z) {
        this.z = z;
    }

    public void drawAxis(Graphics g) {
        drawLine(g, O, i);
        drawLine(g, O, j);
        drawLine(g, O, k);
    }

    public void drawAxis(Graphics g, int xLength, int yLength, boolean details , Color color) {
        s2.drawAxis(g, xLength, yLength, details, color);
    }

    public void drawPoint(Graphics g, V3 p) {
        s2.drawPoint(g, project(p));
    }

    public void drawPoint(Graphics g, V3 p, Color color) {
        s2.drawPoint(g, project(p), color);
    }

    public void drawPoint(Graphics g, V3 p, Color color, int diameter) {
        s2.drawPoint(g, project(p), color, diameter);
    }

    public void drawLine(Graphics g, V3 p1, V3 p2) {
        s2.drawLine(g, project(p1), project(p2));
    }

    public void drawLine(Graphics g, V3 p1, V3 p2, Color color) {
        s2.drawLine(g, project(p1), project(p2), color);
    }

    public void drawLine(Graphics g, V3 p1, V3 p2, Color color, float weight) {
        s2.drawLine(g, project(p1), project(p2), color, weight);
    }

    M3 I = new M3(1,0,0,
                  0,1,0,
                  0,0,1);
    M3 Sz3 = new M3( 0, -1, 1,
            1, 0, -1,
            -1, 1, 0);

    public void yaw(double angle) {
        //SZ3*U
        M3 Sx = null;
        double phi = (PI/180)*angle;
        M3 Rx = I.add(Sx.mul(sin(phi))).add(Sx.mul(Sx).mul(1-cos(phi)));
        D = Rx.mul(D).unit();
        R = D.cross(k).unit();
        U = R.cross(D);
    }

    //NONE OF THE BELOW IS DONE.
    public void pitch(double angle) {
       //SZ3*D
        M3 Sz = null;
        double phi = (PI/180)*angle;
        M3 Rz = I.add(Sz.mul(sin(phi))).add(Sz.mul(Sz).mul(1-cos(phi)));
        U = Rz.mul(U);
        R = Rz.mul(R);
        //D = R.cross(U);
    }

    public void roll(double angle) {
        //SZ3*R
        M3 Sy = null;
        double phi = (PI/180)*angle;
        M3 Ry = I.add(Sy.mul(sin(phi))).add(Sy.mul(Sy).mul(1-cos(phi)));
        R = Ry.mul(R);
        U = Ry.mul(U);
    }


}
