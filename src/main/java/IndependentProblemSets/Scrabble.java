package IndependentProblemSets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Scrabble {
    static BufferedReader r;
    static BufferedWriter w;
    public static boolean isCon(char c) {
        return c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }
    public static boolean isCon(char c, char h) {
        return c == 'N' && h == 'G';
    }
    public static boolean isVow(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y';
    }
    public static int solution() throws IOException {
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = r.readLine();
        int p1 = 0;
        int p2 = 0;
        int len = 0;
        while (p1 < in.length()) {
            if (isCon(in.charAt(p1))) {
                if (isVow(in.charAt(p1 + 1))) {

                } else {

                }
            } else if (p1 != in.length() - 1 && isCon(in.charAt(p1), in.charAt(p1 + 1))) {

            } else {
                p1++;
                p2 = p1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {}
}
