package shapes;

public class SquarePrism extends Shape3D {
    private double side;

    public SquarePrism(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        return side * side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}