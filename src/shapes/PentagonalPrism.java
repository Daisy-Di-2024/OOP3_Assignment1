package shapes;

public class PentagonalPrism extends Shape3D {
    private double side;

    public PentagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        return (5.0 / 2.0) * side * side * Math.sqrt(5 + 2 * Math.sqrt(5));
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

}
