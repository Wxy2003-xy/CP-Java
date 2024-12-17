package input_output;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader reader;
    static BufferedWriter writer;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            solve();
        }

        reader.close();
        writer.close();
    }

    static void solve() throws IOException {
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        writer.write("ans" + "\n");
    }
}