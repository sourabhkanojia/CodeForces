import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),l=sc.nextInt();
        int[] c=new int[n];
        for(int i=0;i<n;i++)c[i]=sc.nextInt();
        for(int i=1;i<n;i++)c[i]=Math.min(c[i],2*c[i-1]);
        long ans=Long.MAX_VALUE,sum=0;
        for(int i=n-1;i>=0;i--){
            long need=l/(1<<i);
            sum+=need*c[i];
            l-=need*(1<<i);
            ans=Math.min(ans,sum+((l>0)?1:0)*c[i]);
        }
        System.out.println(ans);
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
