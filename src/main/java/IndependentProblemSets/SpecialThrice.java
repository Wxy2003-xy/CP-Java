package IndependentProblemSets;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Util.MapPrinter.mapTo2DStream;
import static Util.MapPrinter.printMapInTable;
import static java.lang.Integer.parseInt;

public class SpecialThrice {
    public static int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    break;
                }
                if (map.containsKey(s.substring(i, j + 1))) {
                    map.put(s.substring(i, j + 1), map.get(s.substring(i, j + 1)) + 1);
                } else {
                    map.put(s.substring(i, j + 1), 1);
                }
            }
            i++;
        }
        int len = -1;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= 3 && entry.getKey().length() > len) {
                len = entry.getKey().length();
            }
        }
        return len;
    }

    public static Map<String, Integer> toMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    break;
                }
                if (map.containsKey(s.substring(i, j + 1))) {
                    map.put(s.substring(i, j + 1), map.get(s.substring(i, j + 1)) + 1);
                } else {
                    map.put(s.substring(i, j + 1), 1);
                }
            }
            i++;
          }
        return map;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "aaa";
        String s = "ccccc";
        String t = "abacccccb";
        String c = "abcccccddddabcccccddddabcccccdddd";
        String d = "jinhhhtttttttefffffjjjjjjjjjfffffjjjjjjjjjzvvvvvvg";
        String e = "aaaaaaaaaaaaccccccccccccccccccccccccccaaaaaaaaaaaa";
        String f = "aaaaaaaaaaaaaaaaaaaabbbbbbbbbbaaaaaaaaaaaaaaaaaaaa";
        String g = "zzzzzzzzzzzzzzzzzfffffdddddddddiiiiiiiiiiiiiiiiiii";
        String h = "zzzzzzzzzzzsssssssssssssssssqppppppppppppppnqmosat";
        System.out.println(maximumLength(a));
    }
}
