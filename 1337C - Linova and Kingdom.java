import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] depth,sub;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        adj=new ArrayList[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
        depth=new int[n];
        sub=new int[n];
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(0,-1);
        Integer[] sum=new Integer[n];
        for(int i=0;i<n;i++){
            sum[i]=depth[i]-sub[i];
        }
        Arrays.sort(sum);
        long ans=0;
        for(int i=0;i<k;i++)ans+=sum[n-1-i];
        System.out.println(ans);
    }
    static int dfs(int curr,int par){
        if(par==-1)depth[curr]=1;
        else depth[curr]=depth[par]+1;
        sub[curr]=1;
        for(int node:adj[curr]){
            if(node!=par){
                sub[curr]+=dfs(node,curr);
            }
        }
        return sub[curr];
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
