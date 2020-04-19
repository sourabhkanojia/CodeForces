import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            dp=new int[201][n];
            for(int i=0;i<n;i++){
                dp[a[i]=sc.nextInt()][i]++;
                if(i>0){
                    for(int j=1;j<=200;j++)dp[j][i]=dp[j][i]+dp[j][i-1];
                }
            }
            int ans=0;
            for(int j=1;j<=200;j++)ans=Math.max(ans,dp[j][n-1]);
            for(int i=0;i<n-1;i++){
                int x=dp[a[i]][n-1];
                int y=dp[a[i]][i];
                if(x-y>=y){
                    int l=i,r=n,val=x-2*y;
                    while(l+1<r){
                        int mid=l+(r-l)/2;
                        if(dp[a[i]][mid]-dp[a[i]][i]<=val)l=mid;
                        else r=mid;
                    }
                    ans=Math.max(ans,2*y+solve(i+1,l));
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
    static int solve(int l,int r){
        int max=0;
        if(l==r)return 1;
        for(int i=1;i<=200;i++){
            max=Math.max(max,dp[i][r]-dp[i][l-1]);
        }
        return max;
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
