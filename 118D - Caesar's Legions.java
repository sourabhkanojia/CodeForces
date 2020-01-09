import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main {
    static long[][][][] dp;
    static int n1,n2,k1,k2,mod=(int)1e8;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        n1=sc.nextInt();n2=sc.nextInt();k1=sc.nextInt();k2=sc.nextInt();
        dp=new long[101][101][11][11];
        for(long[][][] a:dp)for(long[][] b:a)for(long[] c:b)Arrays.fill(c,-1);
        long ans=dp(n1,n2,0,0)%mod;
        System.out.println(ans);
    }
    public static long dp(int a,int b,int count1,int count2){
        if(a==0 && b==0)return 1;

        if(dp[a][b][count1][count2]!=-1)return dp[a][b][count1][count2];

        long count=0;
        if(a>0 && count1!=k1){
            if(count2==k2) count=(count+dp(a-1,b,1,0)%mod)%mod;
            else count=(count+dp(a-1,b,count1+1,0)%mod)%mod;
        }
        if(b>0 && count2!=k2){
            if(count1==k1)count=(count+dp(a,b-1,0,1)%mod)%mod;
            else count=(count+dp(a,b-1,0,count2+1)%mod)%mod;
        }

        return dp[a][b][count1][count2]=count;
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
