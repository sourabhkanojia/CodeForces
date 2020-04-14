import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] parent,deg,depth;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        adj=new ArrayList[n];
        parent=new int[n];
        deg=new int[n];
        depth=new int[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
            deg[u]++;
            deg[v]++;
        }
        int root=-1;
        for(int i=0;i<n;i++){
            if(deg[i]>1){
                root=i;
                break;
            }
        }
        dfs(root,-1,0);
        int min=1,max=n-1,odd=0,even=0;
        for(int i=0;i<n;i++){
            if(deg[i]==1){
                if((depth[i]&1)==1)odd++;
                else even++;
            }
        }
        if(odd!=0 && even!=0)min=3;
        for(int i=0;i<n;i++){
            int count=0;
            for(int node:adj[i]){
                if(deg[node]==1)count++;
            }
            max-=Math.max(0,count-1);
        }
        System.out.println(min+" "+max);
    }
    static void dfs(int curr,int par,int dist){
        parent[curr]=par;
        depth[curr]=dist;
        for(int node:adj[curr]){
            if(node!=par){
                dfs(node,curr,dist+1);
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
