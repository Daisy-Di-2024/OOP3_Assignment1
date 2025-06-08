package utilities;

import java.util.Arrays;
import java.util.List;

import shapes.*;

public class ShapeTest {
    public static void main(String[] args) {
        Shape3D cylinder = new Cylinder(5, 10);
        Shape3D squarePrism = new SquarePrism(4, 11);
    
        System.out.println("Cylinder: " + cylinder);
        System.out.println("SquarePrism: " + squarePrism);
        
        VolumeComparator volumeComparator = new VolumeComparator();
        System.out.println("Volume comparison: " + volumeComparator.compare(cylinder, squarePrism));
        
        BaseAreaComparator baseAreaComparator = new BaseAreaComparator();
        System.out.println("Base area comparison: " + baseAreaComparator.compare(cylinder, squarePrism));

        List<Shape3D> shapes = Arrays.asList(cylinder, squarePrism);
        System.out.println("Shapes list: " + shapes);
        System.out.println("Sorted by volume:");
        shapes.stream()
                .sorted(volumeComparator)
                .forEach(shape -> System.out.println(shape));
        System.out.println("Sorted by base area:");
        shapes.stream()
                .sorted(baseAreaComparator)
                .forEach(shape -> System.out.println(shape));
        System.out.println("Sorted by height:");
        shapes.stream()
                .sorted()
                .forEach(shape -> System.out.println(shape));
    }
}
