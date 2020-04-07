import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        n=sc.nextInt(); m=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        if(n>m){
            System.out.println("YES");
            return;
        }
        dp=new int[n][m+1];
        for(int[] i:dp)Arrays.fill(i,-1);
        if(solve(0,m)==1) System.out.println("YES");
        else System.out.println("NO");
    }
    static int solve(int i,int rem){
        if(i==n){
            if(rem==0)return 1;
            else return 0;
        }
        if(rem==0)return 1;
        if(dp[i][rem]!=-1)return dp[i][rem];
        return dp[i][rem]=solve(i+1,(arr[i]+rem)%m) | solve(i+1,rem);
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
