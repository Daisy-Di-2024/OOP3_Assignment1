/*
 * Sort Shapes CLI
 *
 * Usage:
 *   java -jar Sort.jar -f <file> -t <h|v|a> -s <b|i|s|m|q|z>
 *
 * Examples:
 *   java -jar Sort.jar -f res/shapes1.txt -t h -s b   // sort by height with bubble sort
 *   java -jar Sort.jar -f res/shapes2.txt -t v -s q   // sort by volume with quick sort
 *   java -jar Sort.jar -f Big.txt       -t a -s m   // sort by base area with merge sort
 *   java -jar Sort.jar --help                      // show this help message
 *
 * Options:
 *   -f <file>        Path to input file (each line: ShapeName dimension1 dimension2)
 *   -t <h|v|a>       Sort key: h=height, v=volume, a=base area
 *   -s <b|i|s|m|q|z>  Algorithm: b=bubble, i=insertion, s=selection, m=merge, q=quick, z=heap
 *
 * Output:
 *   Sort time: <milliseconds> ms
 *   Prints the first, last, and every 1000th shape after sorting.
 */
package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import shapes.*;
import utilities.SortUtils;

public class AppDriver {
    public static void main(String[] args) {
        if (args.length == 0 || hasHelpFlag(args)) {
            printHelpAndExit();
        }

String inputFile = null;
char sortKey = 0;
char algorithm = 0;

for (int i = 0; i < args.length; i++) {
    String arg = args[i];
    String argLower = arg.toLowerCase();
    switch (argLower) {
        case "-f":
            if (i + 1 < args.length) inputFile = args[++i];
            else usageError("Missing file path after -f");
            break;
        case "-t":
            if (i + 1 < args.length) sortKey = args[++i].charAt(0);
            else usageError("Missing sort key after -t");
            break;
        case "-s":
            if (i + 1 < args.length) algorithm = args[++i].charAt(0);
            else usageError("Missing algorithm code after -s");
            break;
        default:
            if (argLower.startsWith("-f")) inputFile = arg.substring(2);
            else if (argLower.startsWith("-t")) sortKey = arg.charAt(2);
            else if (argLower.startsWith("-s")) algorithm = arg.charAt(2);
            else usageError("Unknown option: " + arg);
    }
}
        if (inputFile == null) {
        usageError("Missing -f <file>");
        }
        if (sortKey == 0 || algorithm == 0) {
            usageError("Missing sort key (-t) or algorithm (-s)");
        }
        sortKey = Character.toLowerCase(sortKey);
        algorithm = Character.toLowerCase(algorithm);


        Shape3D[] shapes = loadShapes(inputFile);
        Sorter sorter = selectSorter(sortKey);

        long start = System.nanoTime();
        sorter.sort(shapes, algorithm);
        long duration = (System.nanoTime() - start) / 1_000_000;

        //System.out.println("Sort time: " + duration + " ms");
        String algName = getAlgorithmName(algorithm);
        // System.out.println( algName + " Run Time was: " + duration + " ms");
        printResults(shapes);
        //String algName = getAlgorithmName(algorithm);
        System.out.println( algName + " Run Time was: " + duration + " ms");
    }

    private static boolean hasHelpFlag(String[] args) {
        for (String arg : args) {
            if ("--help".equals(arg) || "-help".equals(arg)) return true;
        }
        return false;
    }

    private static Shape3D[] loadShapes(String filename) {
        if (!filename.contains("/") && !filename.contains("\\")) {
        filename = "res/" + filename;
    }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int count = Integer.parseInt(reader.readLine().trim());
            //System.out.println("Number of shapes to read: " + count); // Debugging line
            Shape3D[] arr = new Shape3D[count];
            for (int i = 0; i < count; i++) {
                String[] parts = reader.readLine().trim().split("\\s+");
                double p1 = Double.parseDouble(parts[1]);
                double p2 = Double.parseDouble(parts[2]);
                arr[i] = createShape(parts[0].toLowerCase(), p1, p2);
            }
            return arr;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading shapes: " + e.getMessage());
            System.exit(1);
            return new Shape3D[0];
        }
    }

    private static Shape3D createShape(String type, double dim1, double dim2) {
        switch (type) {
            case "cylinder":        return new Cylinder(dim1, dim2);
            case "cone":            return new Cone(dim1, dim2);
            case "pyramid":         return new Pyramid(dim1, dim2);
            case "squareprism":     return new SquarePrism(dim1, dim2);
            case "triangularprism": return new TriangularPrism(dim1, dim2);
            case "pentagonalprism": return new PentagonalPrism(dim1, dim2);
            case "octagonalprism":  return new OctagonalPrism(dim1, dim2);
            default:
                System.err.println("Unknown shape: " + type);
                System.exit(1);
                return null;
        }
    }

    private static Sorter selectSorter(char key) {
        switch (key) {
            case 'h': return new HeightSorter();
            case 'v': return new VolumeSorter();
            case 'a': return new BaseAreaSorter();
            default:  usageError("Invalid sort key: " + key); return null;
        }
    }

    private static void printResults(Shape3D[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        if (i == 0) {
            System.out.println("Item [first]:");
        } else if (i == n - 1) {
            System.out.println("Item [last]:");
        } else if ((i + 1) % 1000 == 0) {
            System.out.printf("Item [%d-th]:%n", i + 1);
        } else {
            continue;
        }
        System.out.println(arr[i].toFormattedString());
        
        //System.out.printf("Total items printed: %d%n", n);
        
    }
}


    private static void usageError(String msg) {
        System.err.println("Error: " + msg);
        System.err.println("Usage: java -jar Sort.jar -f <file> -t <h|v|a> -s <b|i|s|m|q|z>");
        System.exit(1);
    }

    private static void printHelpAndExit() {
        System.out.println("Usage: java -jar Sort.jar -f <file> -t <h|v|a> -s <b|i|s|m|q|z>");
        System.out.println("  -f <file>        input file path");
        System.out.println("  -t <h|v|a>       sort by height, volume, or base area");
        System.out.println("  -s <b|i|s|m|q|z>  choose bubble, insertion, selection, merge, quick, or heap");
        System.out.println("  --help           show this help message");
        System.exit(0);
    }

    private interface Sorter {
        void sort(Shape3D[] arr, char algorithm);
    }

    private static class HeightSorter implements Sorter {
        public void sort(Shape3D[] arr, char alg) {
            switch (alg) {
                case 'b': SortUtils.bubbleSortByHeight(arr); break;
                case 'i': SortUtils.insertionSortByHeight(arr); break;
                case 's': SortUtils.selectionSortByHeight(arr); break;
                case 'm': SortUtils.mergeSortByHeight(arr); break;
                case 'q': SortUtils.quickSortByHeight(arr); break;
                case 'z': SortUtils.heapSortByHeight(arr); break;
                default: usageError("Invalid algorithm: " + alg);
            }
        }
    }

    private static class VolumeSorter implements Sorter {
        public void sort(Shape3D[] arr, char alg) {
            switch (alg) {
                case 'b': SortUtils.bubbleSortByVolume(arr); break;
                case 'i': SortUtils.insertionSortByVolume(arr); break;
                case 's': SortUtils.selectionSortByVolume(arr); break;
                case 'm': SortUtils.mergeSortByVolume(arr); break;
                case 'q': SortUtils.quickSortByVolume(arr); break;
                case 'z': SortUtils.heapSortByVolume(arr); break;
                default: usageError("Invalid algorithm: " + alg);
            }
        }
    }

    private static class BaseAreaSorter implements Sorter {
        public void sort(Shape3D[] arr, char alg) {
            switch (alg) {
                case 'b': SortUtils.bubbleSortByBaseArea(arr); break;
                case 'i': SortUtils.insertionSortByBaseArea(arr); break;
                case 's': SortUtils.selectionSortByBaseArea(arr); break;
                case 'm': SortUtils.mergeSortByBaseArea(arr); break;
                case 'q': SortUtils.quickSortByBaseArea(arr); break;
                case 'z': SortUtils.heapSortByBaseArea(arr); break;
                default: usageError("Invalid algorithm: " + alg);
            }
        }
    }
    public static String getAlgorithmName(char algorithm) {
        switch (algorithm) {
            case 'b': return "Bubble Sort";
            case 'i': return "Insertion Sort";
            case 's': return "Selection Sort";
            case 'm': return "Merge Sort";
            case 'q': return "Quick Sort";
            case 'z': return "Heap Sort";
            default:  return "Unknown Algorithm";
        }
    }
}
