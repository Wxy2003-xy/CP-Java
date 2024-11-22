package Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMethods {
    public static <T> void printStream2D(Stream<Stream<T>> stream) {
        stream.forEach(innerStream -> {
            innerStream.forEach(element -> System.out.print(element + " "));
            System.out.println(); // Move to the next line after printing each inner stream
        });
    }

    private int[] subarray(int[] arr, int init, int end) {
        int len = end - init + 1;
        int[] res = new int[len];
        for (int i = init; i <= end; i++) {
            res[i - init] = arr[i];
        }
        return res;
    }

    public static Stream<Stream<Integer>> permute(Stream<Integer> stream) {
        return permuteHelper(stream.toList()).map(List::stream);
    }

    private static Stream<List<Integer>> permuteHelper(List<Integer> list) {
        if (list.isEmpty()) {
            return Stream.of(List.of());
        }
        return list.stream().flatMap(i ->
                permuteHelper(list.stream().filter(j -> !j.equals(i)).toList())
                        .map(rest -> Stream.concat(Stream.of(i), rest.stream()).toList())
        );
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Stream<Integer> s = Arrays.stream(arr).boxed();
        printStream2D(permute(s));
    }
}
