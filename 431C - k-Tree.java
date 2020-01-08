import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    static long[][] dp;
    static int n,k,d,mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        n=sc.nextInt();k=sc.nextInt();d=sc.nextInt();
        dp=new long[2][n+1];
        for(long[] i:dp)Arrays.fill(i,-1);
        System.out.println(solve(n,0));
    }
    static long solve(int s,int z){
        if(s==0){
            if(z==1)return 1;
            else return 0;
        }
        if(dp[z][s]!=-1)return dp[z][s];
        long count=0;
        for(int i=1;i<=k;i++){
            if(s-i>=0){
                if(z==1)count=count+solve(s-i,1)%mod;
                else count=count+(solve(s-i,i>=d?1:0)%mod);
            }
        }
        return dp[z][s]=count%mod;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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

    double nextDouble() {
        return Double.parseDouble(next());
    }

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
