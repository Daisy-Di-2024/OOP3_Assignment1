package shapes;

public class Cylinder extends Shape3D {

    private double radius;

    public Cylinder(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    public double calcBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double calcVolume() {
        return calcBaseArea() * height;
    }

}
