import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static long[] f;
    static int d,mod=(int)1e9+7;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        d=sc.nextInt();
        int n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        graph g=new graph(n);
        for(int i=1;i<=n-1;i++)g.addEdge(sc.nextInt()-1,sc.nextInt()-1);
        vis=new boolean[n];
        f=new long[n];
        long sum=0;
        for(int i=0;i<n;i++){
            Arrays.fill(vis,false);
            Arrays.fill(f,0);
            g.dfs(i,i);
            sum=(sum+f[i])%mod;
        }
        System.out.println(sum);
    }
    static class graph{
        int v;
        LinkedList<Integer>[] ll;
        public graph(int v){
            this.v=v;
            ll=new LinkedList[v];
            for(int i=0;i<v;i++)ll[i]=new LinkedList<>();
        }
        public void addEdge(int u,int v){
            ll[u].add(v);
            ll[v].add(u);
        }
        public void dfs(int root,int node) {
            vis[node]=true;
            f[node]=1;
           for(int i:ll[node]){
             if(!vis[i]){
                 if(arr[i]<arr[root] || arr[i]>arr[root]+d)continue;
                 if(arr[i]==arr[root] && root<i)continue;
                 dfs(root,i);
                 f[node]=f[node]*(f[i]+1)%mod;
             }
           }

        }
    }
}
