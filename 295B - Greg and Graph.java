mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int[][] adj=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j]=sc.nextInt();
            }
        }
        int[] x=new int[n];
        for(int i=0;i<n;i++)x[i]=sc.nextInt()-1;
        long[] dp=new long[n];
        for(int i=n-1;i>=0;i--){
            int j=x[i];
            long sum=0;
            for(int k=0;k<n;k++){
                for(int l=0;l<n;l++){
                    if(adj[k][j]+adj[j][l]<adj[k][l]){
                        adj[k][l]=adj[k][j]+adj[j][l];
                    }
                }
            }
            for(int k=i;k<n;k++){
                for(int l=i;l<n;l++){
                    sum+=adj[x[k]][x[l]];
                }
            }
            dp[i]=sum;
        }
        for(int i=0;i<n;i++)sb.append(dp[i]+" ");
        System.out.println(sb);
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
