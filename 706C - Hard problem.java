import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static long INF=(long)1e18;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        int[] c=new int[n];
        for(int i=0;i<n;i++)c[i]=sc.nextInt();
        String[][] str=new String[2][n];
        for(int i=0;i<n;i++){
            str[0][i]=sc.next();
            str[1][i]=new StringBuilder(str[0][i]).reverse().toString();
        }
        long[][] dp=new long[2][n];
        Arrays.fill(dp[0],INF);
        Arrays.fill(dp[1],INF);
        dp[0][0]=0;
        dp[1][0]=c[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=1;j++){
                long ans=INF;
                for(int k=0;k<=1;k++){
                    if(str[k][i-1].compareTo(str[j][i])<=0){
                        ans=Math.min(ans,dp[k][i-1]+j*c[i]);
                    }
                }
                dp[j][i]=ans;
            }
        }
        long sol=Math.min(dp[0][n-1],dp[1][n-1]);
        System.out.println(sol>=INF?-1:sol);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }
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
    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }
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
