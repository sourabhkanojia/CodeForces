import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        long GCD[] = new long[n];
        GCD[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            GCD[i] = gcd(GCD[i + 1], arr[i]);
        }
        ArrayList<Long> temp = new ArrayList<>();
        for (int i = 0; i < n - 1; i++)temp.add(lcm(arr[i], GCD[i + 1]));

        if (temp.isEmpty()) {
            System.out.println(1);
            return;
        }
        long ans = temp.get(0);
        for (int i = 1; i < temp.size(); i++) ans = gcd(ans, temp.get(i));
        System.out.println(ans);
    }
    static long gcd(long a,long b){
        if (a==0)return b;
        return gcd(b%a,a);
    }
    static long lcm(long a,long b){
        return (long)a*b/gcd(a,b);
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
