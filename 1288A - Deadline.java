import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(t-->0) {
            long n = sc.nextInt(), d = sc.nextInt();
            long x = (n - 1) / 2, b = n - d;
            long a = x * x + x * (1 - n);
            if (a <= b) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
