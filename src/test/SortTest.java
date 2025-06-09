package test;

import shapes.*;
import utilities.SortUtils;

public class SortTest {
    public static void main(String[] args) {

        Shape3D cylinder = new Cylinder(5, 10);
        Shape3D squarePrism = new SquarePrism(4, 11);
        Shape3D cone = new Cone(3, 8);
        Shape3D octagonalPrism = new OctagonalPrism(2, 9);
        Shape3D pentagonalPrism = new PentagonalPrism(3, 7);
        Shape3D pyramid = new Pyramid(4, 6);
        Shape3D squarePrism2 = new SquarePrism(5, 12);
        Shape3D triangularPrism = new TriangularPrism(3, 10);

        // Testing all sort methods with the same dataset
        Shape3D[] originalShapes = { squarePrism, cone, octagonalPrism, pentagonalPrism, pyramid,
                squarePrism2, triangularPrism, cylinder };

        // Test each sort method
        System.out.println("\nTesting bubble sort methods:");
        Shape3D[] bubbleShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", bubbleShapes);
        SortUtils.bubbleSortByHeight(bubbleShapes);
        printShapes("Shape array sorted by height:", bubbleShapes);
        SortUtils.bubbleSortByVolume(bubbleShapes);
        SortUtils.bubbleSortByBaseArea(bubbleShapes);
        printShapes("Shape array sorted by base area:", bubbleShapes);
        printShapes("Shape array sorted by volume:", bubbleShapes);

        System.out.println("\nTesting insertion sort methods:");
        Shape3D[] insertionShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", insertionShapes);
        SortUtils.insertionSortByHeight(insertionShapes);
        printShapes("Shape array sorted by height:", insertionShapes);
        SortUtils.insertionSortByBaseArea(insertionShapes);
        printShapes("Shape array sorted by base area:", insertionShapes);
        SortUtils.insertionSortByVolume(insertionShapes);
        printShapes("Shape array sorted by volume:", insertionShapes);

        System.out.println("\nTesting selection sort methods:");
        Shape3D[] selectionShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", selectionShapes);
        SortUtils.selectionSortByHeight(selectionShapes);
        printShapes("Shape array sorted by height:", selectionShapes);
        SortUtils.selectionSortByBaseArea(selectionShapes);
        printShapes("Shape array sorted by base area:", selectionShapes);
        SortUtils.selectionSortByVolume(selectionShapes);
        printShapes("Shape array sorted by volume:", selectionShapes);

        System.out.println("\nTesting merge sort methods:");
        Shape3D[] mergeShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", mergeShapes);
        SortUtils.mergeSortByHeight(mergeShapes);
        printShapes("Shape array sorted by height:", mergeShapes);
        SortUtils.mergeSortByBaseArea(mergeShapes);
        printShapes("Shape array sorted by base area:", mergeShapes);
        SortUtils.mergeSortByVolume(mergeShapes);
        printShapes("Shape array sorted by volume:", mergeShapes);

        System.out.println("\nTesting quick sort methods:");
        Shape3D[] quickShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", quickShapes);
        SortUtils.quickSortByHeight(quickShapes);
        printShapes("Shape array sorted by height:", quickShapes);
        SortUtils.quickSortByBaseArea(quickShapes);
        printShapes("Shape array sorted by base area:", quickShapes);
        SortUtils.quickSortByVolume(quickShapes);
        printShapes("Shape array sorted by volume:", quickShapes);

        System.out.println("\nTesting heap sort methods:");
        Shape3D[] heapShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", heapShapes);
        SortUtils.heapSortByHeight(heapShapes);
        printShapes("Shape array sorted by height:", heapShapes);
        SortUtils.heapSortByBaseArea(heapShapes);
        printShapes("Shape array sorted by base area:", heapShapes);

        SortUtils.heapSortByVolume(heapShapes);
        printShapes("Shape array sorted by volume:", heapShapes);

    }

    public static void printShapes(String title, Shape3D[] shapes) {
        System.out.println(title);
        for (Shape3D shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("------------------------------------------------------------------------");
    }

}
