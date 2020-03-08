import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt(),k=sc.nextInt();
        n=a<b?b:n-b+1;
        a=Math.abs(a-b);
        int[][] dp=new int[k+1][n];
        for(int i=0;i<n;i++)dp[0][i]=i;
        for(int i=1;i<=k;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=(((dp[i-1][Math.min(j+j-1,n-1)]-((dp[i-1][j]-dp[i-1][j-1]+mod)%mod)+mod)%mod)+dp[i][j-1])%mod;
            }
        }
        System.out.println((dp[k][a]-dp[k][a-1]+mod)%mod);
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
