package Misc;

import java.util.List;
import java.util.stream.Stream;

public class Lisp {
    // 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16...
    // 1,3,3,3,5,5,5,5,5,7, 7, 7, 7, 7, 7, 7...
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.print(oddOdd(i) + ", ");
        }
    }

    public static int oddOdd(int idx) {
        return Stream.iterate(1, i -> i + 2).flatMap(y -> Stream.generate(() -> y).limit(y)).skip(idx - 1).findFirst().orElse(-1);
    }

}
