package utilities;

import shapes.Shape3D;

import java.util.Comparator;

public class SortUtils {

    // BubbleSort method that takes an array of Shape3D objects and a Comparator.
    // It sorts the array in descending order based on the comparison defined in the
    // Comparator.
    public static void bubbleSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(shapes[j], shapes[j + 1]) < 0) {
                    Shape3D temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                }
            }
        }

    }

    // BubbleSort methods for comparing by height, volume, and base area.
    public static void bubbleSortByHeight(Shape3D[] shapes) {
        bubbleSort(shapes, Comparator.naturalOrder()); // uses compareTo()
    }

    public static void bubbleSortByVolume(Shape3D[] shapes) {
        bubbleSort(shapes, new VolumeComparator());
    }

    public static void bubbleSortByBaseArea(Shape3D[] shapes) {
        bubbleSort(shapes, new BaseAreaComparator());
    }

    // InsertionSort method that takes an array of Shape3D objects and a Comparator.
    // It sorts the array in descending order based on the comparison defined in the
    // Comparator.
    public static void insertionSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        int n = shapes.length;
        for (int i = 1; i < n; i++) {
            Shape3D temp = shapes[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(shapes[j], temp) < 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j + 1] = temp;
        }
    }

    // InsertionSort methods for comparing by height, volume, and base area.
    public static void insertionSortByHeight(Shape3D[] shapes) {
        insertionSort(shapes, Comparator.naturalOrder()); // uses compareTo()
    }

    public static void insertionSortByVolume(Shape3D[] shapes) {
        insertionSort(shapes, new VolumeComparator());
    }

    public static void insertionSortByBaseArea(Shape3D[] shapes) {
        insertionSort(shapes, new BaseAreaComparator());
    }

    // SelectionSort method that takes an array of Shape3D objects and a Comparator.
    // It sorts the array in descending order based on the comparison defined in the
    // Comparator.
    public static void selectionSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(shapes[j], shapes[max]) > 0) {
                    max = j;
                }
            }
            Shape3D temp = shapes[max];
            shapes[max] = shapes[i];
            shapes[i] = temp;
        }
    }

    // SelectionSort methods for comparing by height, volume, and base area.
    public static void selectionSortByHeight(Shape3D[] shapes) {
        selectionSort(shapes, Comparator.naturalOrder()); // uses compareTo()
    }

    public static void selectionSortByVolume(Shape3D[] shapes) {
        selectionSort(shapes, new VolumeComparator());
    }

    public static void selectionSortByBaseArea(Shape3D[] shapes) {
        selectionSort(shapes, new BaseAreaComparator());
    }

    // MergeSort method that takes an array of Shape3D objects and a Comparator.
    // It sorts the array in descending order based on the
    // comparison defined in the Comparator.
    public static void mergeSort(Shape3D[] originalArray, Comparator<Shape3D> comparator) {
        int length = originalArray.length;
        if (length <= 1) {
            return; // Base case: array is already sorted
        }

        int mid = length / 2;
        Shape3D[] leftArray = new Shape3D[mid];
        Shape3D[] rightArray = new Shape3D[length - mid];

        int i = 0; // left array
        int j = 0; // right array
        for (; i < length; i++) {
            if (i < mid) {
                leftArray[i] = originalArray[i];
            } else {
                rightArray[j] = originalArray[i];
                j++;
            }
        }
        mergeSort(leftArray, comparator);
        mergeSort(rightArray, comparator);
        merge(leftArray, rightArray, originalArray, comparator);

    }

    // Merge method that merges two sorted arrays (leftArray and rightArray) into
    // the originalArray in descending order based on the provided comparator.
    public static void merge(Shape3D[] leftArray, Shape3D[] rightArray, Shape3D[] originalArray,
            Comparator<Shape3D> comparator) {
        int leftLength = originalArray.length / 2;
        int rightLength = originalArray.length - leftLength;
        int i = 0, l = 0, r = 0; // indices for original, left, and right arrays

        // Check the condition for merging
        while (l < leftLength && r < rightLength) {
            if (comparator.compare(leftArray[l], rightArray[r]) >= 0) {
                originalArray[i] = leftArray[l];
                i++;
                l++;
            } else {
                originalArray[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftLength) {
            originalArray[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightLength) {
            originalArray[i] = rightArray[r];
            i++;
            r++;
        }
    }

    // MergeSort methods for comparing by height, volume, and base area.
    public static void mergeSortByHeight(Shape3D[] shapes) {
        mergeSort(shapes, Comparator.naturalOrder()); // uses compareTo()
    }

    public static void mergeSortByVolume(Shape3D[] shapes) {
        mergeSort(shapes, new VolumeComparator());
    }

    public static void mergeSortByBaseArea(Shape3D[] shapes) {
        mergeSort(shapes, new BaseAreaComparator());
    }

    // QuickSort method that takes an array of Shape3D objects and a Comparator.
    // It sorts the array in descending order based on the comparison defined in the
    // Comparator.
    public static void quickSort(Shape3D[] shapes, int start, int end, Comparator<Shape3D> comparator) {
        if (end < start) {
            return; // Base case: no elements to sort
        }
        int pivot = partition(shapes, start, end, comparator);
        quickSort(shapes, start, pivot - 1, comparator); // Sort left partition
        quickSort(shapes, pivot + 1, end, comparator); // Sort right partition
    }

    // Partition method that rearranges the elements in the array such that all
    // elements greater than the pivot are on the left side and all elements less
    // than or equal to the pivot are on the right side, based on the provided
    // comparator.
    public static int partition(Shape3D[] shapes, int start, int end, Comparator<Shape3D> comparator) {
        Shape3D pivot = shapes[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (comparator.compare(shapes[j], pivot) > 0) {
                i++;
                Shape3D temp = shapes[i];
                shapes[i] = shapes[j];
                shapes[j] = temp;
            }
        }
        i++;
        Shape3D temp = shapes[i];
        shapes[i] = shapes[end];
        shapes[end] = temp;

        return i; // Return the index of the pivot element

    }

    // QuickSort methods for comparing by height, volume, and base area.
    public static void quickSortByHeight(Shape3D[] shapes) {
        quickSort(shapes, 0, shapes.length - 1, Comparator.naturalOrder()); // uses compareTo()
    }

    public static void quickSortByVolume(Shape3D[] shapes) {
        quickSort(shapes, 0, shapes.length - 1, new VolumeComparator());
    }

    public static void quickSortByBaseArea(Shape3D[] shapes) {
        quickSort(shapes, 0, shapes.length - 1, new BaseAreaComparator());
    }

    // Heapify function that maintains the min-heap property.
    // This helps sort the array in descending order by pushing the smallest
    // elements to the end, leaving the largest elements at the front without
    // reversing.
    public static void heapify(Shape3D[] shapes, int n, int i, Comparator<Shape3D> comparator) {
        int min = i;

        // left index
        int l = 2 * i + 1;

        // right index
        int r = 2 * i + 2;

        // if left child is less than root
        if (l < n && comparator.compare(shapes[l], shapes[min]) < 0) {
            min = l;
        }

        // if right child is less than root
        if (r < n && comparator.compare(shapes[r], shapes[min]) < 0) {
            min = r;
        }

        // if min is not root
        if (min != i) {
            Shape3D temp = shapes[i];
            shapes[i] = shapes[min];
            shapes[min] = temp;

            // Recursively heapify the affected sub-tree
            heapify(shapes, n, min, comparator);
        }
    }

    // HeapSort method that takes an array of Shape3D objects and a Comparator.
    // It sorts the array in descending order based on the comparison defined in the
    // Comparator.
    public static void heapSort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        int n = shapes.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(shapes, n, i, comparator);
        }

        // One By One extract an element form heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            Shape3D temp = shapes[0];
            shapes[0] = shapes[i];
            shapes[i] = temp;

            // Call min heapify on the reduced heap
            heapify(shapes, i, 0, comparator);

        }

    }

    // HeapSort methods for comparing by height, volume, and base area.
    public static void heapSortByHeight(Shape3D[] shapes) {
        heapSort(shapes, Comparator.naturalOrder()); // uses compareTo()
    }

    public static void heapSortByVolume(Shape3D[] shapes) {
        heapSort(shapes, new VolumeComparator());
    }

    public static void heapSortByBaseArea(Shape3D[] shapes) {
        heapSort(shapes, new BaseAreaComparator());
    }

}
