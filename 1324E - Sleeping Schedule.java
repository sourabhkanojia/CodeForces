import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n,h,l,r;
    static int[][] dp;
    static int[] a;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuffer sb = new StringBuffer();
        n=sc.nextInt();h=sc.nextInt();l=sc.nextInt();r=sc.nextInt();
        a=new int[n];
        for (int i=0;i<n;i++)a[i]=sc.nextInt();
        dp=new int[n][20001];
        for (int ar[]:dp)Arrays.fill(ar,-1);
        System.out.println(sol(0,0));
    }
    static int sol(int i,int mod){
        if(i==n)return 0;
        if(dp[i][mod]!=-1)return dp[i][mod];
        int p=(a[i]+mod)%h;
        int q=(a[i]-1+mod)%h;
        int ans1=-1,ans2=-1;

        if(p>=l && p<=r)ans1=sol(i+1,p)+1;
        else ans1=sol(i+1,p);

        if(q>=l && q<=r)ans2=sol(i+1,q)+1;
        else ans2=sol(i+1,q);

        return dp[i][mod]=Math.max(ans1,ans2);
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
