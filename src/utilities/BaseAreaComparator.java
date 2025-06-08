package utilities;

import java.util.Comparator;
import shapes.Shape3D;

public class BaseAreaComparator implements Comparator<Shape3D> {

    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        double area1 = shape1.calcBaseArea();
        double area2 = shape2.calcBaseArea();

        return Double.compare(area1, area2);
    }

}
