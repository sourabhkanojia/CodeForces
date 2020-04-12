import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong(), l = sc.nextLong(), r = sc.nextLong();
            long base, nonBase, startIndex;
            base = (long) Math.floor(l / (2 * n));
            while (((base * 2 * n) - (base * (base + 1)) < l) && (base < n)) base++;

            startIndex = ((base - 1) * 2 * n) - (base * (base - 1));
            for (long j = l; j < r + 1; j++) {
                if (j > ((base * 2 * n) - (base * (base + 1)))) {
                    startIndex = j;
                    base += 1;
                }
                nonBase = base + (j - startIndex + 1) / 2;
                if (j == (n * (n - 1)) + 1) {
                    sb.append(1);
                    break;
                }
                if (j % 2 == 1)sb.append(base+" ");
                else sb.append(nonBase+" ");

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
