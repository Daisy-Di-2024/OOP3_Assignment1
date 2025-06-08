package utilities;

import java.util.Comparator;

import shapes.Shape3D;

public class VolumeComparator implements Comparator<Shape3D> {

    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        double volume1 = shape1.calcVolume();
        double volume2 = shape2.calcVolume();

        return Double.compare(volume1, volume2);
    }

}
