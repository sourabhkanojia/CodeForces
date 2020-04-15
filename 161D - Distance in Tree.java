import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> adj[];
    static int[][] dp;
    static int par[];
    static int k,count=0;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        k=sc.nextInt();
        adj=new ArrayList[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
        dp=new int[k+1][n];
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i=0;i<n;i++)dp[0][i]=1;
        par=new int[n];
        long count=0;
        dfs(0);
        for(int i=0;i<n;i++)count+=dp[k][i];
        count=2*count;
        for (int i=1;i<n;i++){
            for (int j=0;j<=k-2;j++){
                count +=(long) dp[j][i] * (dp[k-1-j][par[i]] - dp[k-2-j][i]);
            }
        }
        System.out.println(count/2);
    }
    static void dfs(int curr){
        for(int node:adj[curr]){
            if(node!=par[curr]){
                par[node]=curr;
                dfs(node);
                for(int i=1;i<=k;i++){
                    dp[i][curr]+=dp[i-1][node];
                }
            }
        }
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
