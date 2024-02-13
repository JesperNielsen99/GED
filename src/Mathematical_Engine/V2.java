package Mathematical_Engine;

public class V2 {
    double x, y;

    public V2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    double length() {
        return Math.sqrt(x*x+y*y);
    }

    V2 add(V2 v) {
        return new V2((x+v.x), (y+v.y));
    }

    V2 sub(V2 v) {
        return new V2((x-v.x), (y-v.y));
    }

    V2 mul(double s) {
        return new V2((x*s), (y*s));
    }

    V2 cross() {
        return new V2(y*-1, x);
    }

    double distance(V2 v) {
        return Math.sqrt((Math.pow((v.x-x), 2))+(Math.pow((v.y-y), 2)));
    }

    double scalar(V2 v) {
        return (x*v.x+y*v.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        V2 v1 = new V2(1,2);
        V2 v2 = new V2(3,5);
        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);
        System.out.println("v1 Length: " + v1.length());
        System.out.println("v1+v2 = " + v1.add(v2));
        System.out.println("v1+v2 Length = " + v1.add(v2).length());
        System.out.println("v1-v2 = " + v1.sub(v2));
        System.out.println("v1-v2 Length = " + v1.sub(v2).length());
        System.out.println("v1+v2 Skalar = " + v1.scalar(v2));
        System.out.println("v1*2 = " + v1.mul(2));
        System.out.println("v1*2 Length = " + v1.mul(2).length());
    }
}
