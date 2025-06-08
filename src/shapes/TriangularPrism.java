package shapes;

public class TriangularPrism extends Shape3D {
    private double side;

    public TriangularPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        return (Math.sqrt(3) / 4) * side * side;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
}
