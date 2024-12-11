package Util;

import java.util.Map;
import java.util.stream.Stream;

public class MapPrinter {
    public static void printMapInTable(Map<?, ?> map) {
        // Determine the column widths
        int keyColumnWidth = "Key".length();
        int valueColumnWidth = "Value".length();

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            keyColumnWidth = Math.max(keyColumnWidth, entry.getKey().toString().length());
            valueColumnWidth = Math.max(valueColumnWidth, entry.getValue().toString().length());
        }

        // Print the header
        String headerFormat = "| %-" + keyColumnWidth + "s | %-" + valueColumnWidth + "s |%n";
        System.out.printf(headerFormat, "Key", "Value");
        printLine(keyColumnWidth, valueColumnWidth);

        // Print the map entries
        String rowFormat = "| %-" + keyColumnWidth + "s | %-" + valueColumnWidth + "s |%n";
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.printf(rowFormat, entry.getKey(), entry.getValue());
        }
        printLine(keyColumnWidth, valueColumnWidth);
    }

    private static void printLine(int keyColumnWidth, int valueColumnWidth) {
        System.out.print("+");
        for (int i = 0; i < keyColumnWidth + 2; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < valueColumnWidth + 2; i++) System.out.print("-");
        System.out.println("+");
    }

    public static <K, V> Stream<Object[]> mapTo2DStream(Map<K, V> map) {
        return map.entrySet().stream()
                .map(entry -> new Object[]{entry.getKey(), entry.getValue()});
    }

    public static void main(String[] args) {
        // Example usage
        Map<String, String> exampleMap = Map.of(
                "Alice", "Engineering",
                "Bob", "Finance",
                "Charlie", "Human Resources"
        );

        printMapInTable(exampleMap);
    }
}
