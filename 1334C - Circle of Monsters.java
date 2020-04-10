import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a=new long[n];
            long[] b=new long[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextLong();
                b[i]=sc.nextLong();
            }
            long count=0;
            for(int i=0;i<n;i++){
                long temp=a[(i+1)%n]-b[i];
                if(temp>0){
                    count+=temp;
                    a[(i+1)%n]=b[i];
                }
            }
            long min=Long.MAX_VALUE;
            for(int i=0;i<n;i++)min=Math.min(min,a[i]);
            sb.append((count+min)+"\n");
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
