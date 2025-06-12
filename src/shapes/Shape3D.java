package shapes;

public abstract class Shape3D implements Comparable<Shape3D> {

    protected double height;

    public Shape3D(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public abstract double calcBaseArea();

    public abstract double calcVolume();

    @Override
    public int compareTo(Shape3D o) {
        if (this.getHeight() < o.getHeight()) {
            return -1;
        } else if (this.getHeight() > o.getHeight()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Shape3D{" +
                "height=" + height +
                ", baseArea=" + calcBaseArea() +
                ", volume=" + calcVolume() +
                '}';
    }
    public String toFormattedString() {
    return String.format("%-15s | Height: %8.2f | Base Area: %10.2f | Volume: %10.2f",
                         this.getClass().getSimpleName(), height, calcBaseArea(), calcVolume());
}
}
