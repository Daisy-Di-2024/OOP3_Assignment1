package test;

import shapes.*;
import utilities.BenchmarkPrinter;
import utilities.SortUtils;

public class SortTest {
    public static void main(String[] args) {
        BenchmarkPrinter benchmarkPrinter = new BenchmarkPrinter();

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

        //Benchmarking bubble sort by height
        Shape3D[] shapeForBenchmark= originalShapes.clone();
        long startTime=System.nanoTime();
        SortUtils.bubbleSortByHeight(shapeForBenchmark);
        long duration=System.nanoTime()-startTime;
        benchmarkPrinter.addResult("Bubble Sort (Height)", duration);
        
        //Benchmarking bubble sort by base area
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.bubbleSortByBaseArea(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Bubble Sort (Base Area)", duration);

        //Benchmarking bubble sort by volume
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.bubbleSortByVolume(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Bubble Sort (Volume)", duration);
        benchmarkPrinter.printResults();
        // End of bubble sort tests
        benchmarkPrinter.clear();


        // Testing insertion sort methods
        System.out.println("\nTesting insertion sort methods:");
        Shape3D[] insertionShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", insertionShapes);
        SortUtils.insertionSortByHeight(insertionShapes);
        printShapes("Shape array sorted by height:", insertionShapes);
        SortUtils.insertionSortByBaseArea(insertionShapes);
        printShapes("Shape array sorted by base area:", insertionShapes);
        SortUtils.insertionSortByVolume(insertionShapes);
        printShapes("Shape array sorted by volume:", insertionShapes);

        //Benchmarking insertion sort by height
        shapeForBenchmark= originalShapes.clone();
        startTime=System.nanoTime();
        SortUtils.insertionSortByHeight(shapeForBenchmark);
        duration=System.nanoTime()-startTime;
        benchmarkPrinter.addResult("Insertion Sort (Height)", duration);

        //Benchmarking insertion sort by base area
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.insertionSortByBaseArea(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Insertion Sort (Base Area)", duration);

        //Benchmarking insertion sort by volume
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.insertionSortByVolume(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Insertion Sort (Volume)", duration);
        benchmarkPrinter.printResults();
        // End of insertion sort tests
        benchmarkPrinter.clear();

        //Testing selection sort methods
        System.out.println("\nTesting selection sort methods:");
        Shape3D[] selectionShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", selectionShapes);
        SortUtils.selectionSortByHeight(selectionShapes);
        printShapes("Shape array sorted by height:", selectionShapes);
        SortUtils.selectionSortByBaseArea(selectionShapes);
        printShapes("Shape array sorted by base area:", selectionShapes);
        SortUtils.selectionSortByVolume(selectionShapes);
        printShapes("Shape array sorted by volume:", selectionShapes);

        //Benchmarking insertion sort by height
        shapeForBenchmark= originalShapes.clone();
        startTime=System.nanoTime();
        SortUtils.selectionSortByHeight(shapeForBenchmark);
        duration=System.nanoTime()-startTime;
        benchmarkPrinter.addResult("Selection Sort (Height)", duration);

        //Benchmarking selection sort by base area
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.selectionSortByBaseArea(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Selection Sort (Base Area)", duration);

        //Benchmarking selection sort by volume
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.selectionSortByVolume(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Selection Sort (Volume)", duration);
        benchmarkPrinter.printResults();
        // End of selection sort tests
        benchmarkPrinter.clear();

        // Testing merge sort methods
        System.out.println("\nTesting merge sort methods:");
        Shape3D[] mergeShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", mergeShapes);
        SortUtils.mergeSortByHeight(mergeShapes);
        printShapes("Shape array sorted by height:", mergeShapes);
        SortUtils.mergeSortByBaseArea(mergeShapes);
        printShapes("Shape array sorted by base area:", mergeShapes);
        SortUtils.mergeSortByVolume(mergeShapes);
        printShapes("Shape array sorted by volume:", mergeShapes);

        //Benchmarking merge sort by height
        shapeForBenchmark= originalShapes.clone();
        startTime=System.nanoTime();
        SortUtils.mergeSortByHeight(shapeForBenchmark);
        duration=System.nanoTime()-startTime;
        benchmarkPrinter.addResult("Merge Sort (Height)", duration);

        //Benchmarking merge sort by base area
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.mergeSortByBaseArea(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Merge Sort (Base Area)", duration);

        //Benchmarking merge sort by volume
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.mergeSortByVolume(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Merge Sort (Volume)", duration);
        benchmarkPrinter.printResults();
        // End of merge sort tests
        benchmarkPrinter.clear();

        //
        System.out.println("\nTesting quick sort methods:");
        Shape3D[] quickShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", quickShapes);
        SortUtils.quickSortByHeight(quickShapes);
        printShapes("Shape array sorted by height:", quickShapes);
        SortUtils.quickSortByBaseArea(quickShapes);
        printShapes("Shape array sorted by base area:", quickShapes);
        SortUtils.quickSortByVolume(quickShapes);
        printShapes("Shape array sorted by volume:", quickShapes);

        //Benchmarking quick sort by height
        shapeForBenchmark= originalShapes.clone();
        startTime=System.nanoTime();
        SortUtils.quickSortByHeight(shapeForBenchmark);
        duration=System.nanoTime()-startTime;
        benchmarkPrinter.addResult("Quick Sort (Height)", duration);

        //Benchmarking quick sort by base area
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.quickSortByBaseArea(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Quick Sort (Base Area)", duration);

        //Benchmarking quick sort by volume
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.quickSortByVolume(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Quick Sort (Volume)", duration);
        benchmarkPrinter.printResults();
        // End of quick sort tests
        benchmarkPrinter.clear();

        //Testing heap sort methods
        System.out.println("\nTesting heap sort methods:");
        Shape3D[] heapShapes = originalShapes.clone();
        printShapes("Shape array before sorting:", heapShapes);
        SortUtils.heapSortByHeight(heapShapes);
        printShapes("Shape array sorted by height:", heapShapes);
        SortUtils.heapSortByBaseArea(heapShapes);
        printShapes("Shape array sorted by base area:", heapShapes);

        SortUtils.heapSortByVolume(heapShapes);
        printShapes("Shape array sorted by volume:", heapShapes);

        //Benchmarking heap sort by height
        shapeForBenchmark= originalShapes.clone();
        startTime=System.nanoTime();
        SortUtils.heapSortByHeight(shapeForBenchmark);
        duration=System.nanoTime()-startTime;
        benchmarkPrinter.addResult("Heap Sort (Height)", duration);

        //Benchmarking heap sort by base area
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.heapSortByBaseArea(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Heap Sort (Base Area)", duration);

        //Benchmarking heap sort by volume
        shapeForBenchmark = originalShapes.clone();
        startTime = System.nanoTime();
        SortUtils.heapSortByVolume(shapeForBenchmark);
        duration = System.nanoTime() - startTime;
        benchmarkPrinter.addResult("Heap Sort (Volume)", duration);
        benchmarkPrinter.printResults();
        // End of heap sort tests
        benchmarkPrinter.clear();
    }

    public static void printShapes(String title, Shape3D[] shapes) {
        System.out.println(title);
        for (Shape3D shape : shapes) {
            System.out.println(shape.toFormattedString());
        }
        System.out.println("------------------------------------------------------------------------");
    }

}
