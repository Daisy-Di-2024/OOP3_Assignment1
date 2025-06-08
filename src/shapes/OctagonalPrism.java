package shapes;

public class OctagonalPrism extends Shape3D {
    private double side;

    public OctagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

}
