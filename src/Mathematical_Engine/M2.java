package Mathematical_Engine;

public class M2 {
    double a, b;
    double c, d;

    public M2(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public V2 mul(V2 v) {
        return new V2(a *v.x+ b *v.y, c *v.x+ d *v.y);
    }

    public M2 mul(M2 m) {
        return new M2(a*m.a + b*m.c, a*m.b + b*m.d, c*m.a + d*m.c, c*m.b + d*m.d);
    }

    public String toString() {
        return  "(" + a + ", " + b + ")" + "\n" +
                "(" + c + ", " + d + ")";
    }

    public static void main(String[] args) {
        M2 m1 = new M2(1,2,3,4);
        M2 m2 = new M2(6,5,4,3);
        V2 v1 = new V2(3,4);
        System.out.println("M1:\n" + m1);
        System.out.println("M2:\n" + m2);
        System.out.println("V1:\n" + v1);
        System.out.println("M1*V1 =\n" + m1.mul(v1));
        System.out.println();
        System.out.println("M1*M2 =\n" + m1.mul(m2));
    }
}
