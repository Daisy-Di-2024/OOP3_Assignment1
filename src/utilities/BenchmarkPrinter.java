package utilities;

import java.util.LinkedHashMap;
import java.util.Map;

public class BenchmarkPrinter {
    // This class is used to print the results of benchmark tests for sorting algorithms.
    private final Map<String, Long> results=new LinkedHashMap<>();
    public void addResult(String algorithm, long duration) {
        results.put(algorithm, duration);
    }
    public void clear() {
        results.clear();
    }
    // Prints the benchmark results in a formatted table.
    public void printResults() {
        System.out.println("------------ Benchmark Results ------------");
        System.out.printf("%-26s | %-15s\n", "Algorithm", "Duration (ms)");
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, Long> entry : results.entrySet()) {
            System.out.printf("%-26s | %-15d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("-------------------------------------------");
    }

}
