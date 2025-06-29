package shapes;

public class Pyramid extends Shape3D {
    private double side;

    public Pyramid(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        return side * side;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * calcBaseArea() * getHeight();
    }
}
