import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        for(int i=1;i<=n;i++)dp[i][i]=arr[i-1];

        for(int i=1;i<n;i++){
            for(int j=1;j+i<=n;j++){
                for(int k=j;k<j+i;k++){
                    if(dp[j][k]!=0 && dp[k+1][j+i]==dp[j][k]){
                        dp[j][j+i]=dp[j][k]+1;
                    }
                }
            }
        }
        int[] dp1=new int[n+1];
        for(int i=1;i<=n;i++){
            dp1[i]=n;
            for(int j=1;j<=i;j++){
                if(dp[j][i]!=0){
                    dp1[i]=Math.min(dp1[i],dp1[j-1]+1);
                }
            }
        }
        System.out.println(dp1[n]);
    }
    static class FastReader {
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
}
