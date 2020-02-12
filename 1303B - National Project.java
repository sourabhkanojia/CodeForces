import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int[][] shows;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            long n=sc.nextInt(),g=sc.nextInt(),b=sc.nextInt();
            long x=(long)Math.ceil(n/(2.0*g));
            if((x-1)*b<=n-x*g) System.out.println(n);
            else System.out.println((long)Math.ceil(n/2.0)+Math.max((x-1)*b,n-(long)Math.ceil(n/2.0)));
        }
    }
}
