import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static boolean[] vis;
    static int[] a,count,ans;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)adj[i]=new LinkedList<>();
        a =new int[n];
        count=new int[n];
        ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(a[i]==0)a[i]--;
        }
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs1(0,0);
        dfs2(0,0,0);
        for(int i=0;i<n;i++)sb.append(ans[i]+" ");
        System.out.println(sb);
    }
    static void dfs1(int i,int par){
        for(int node:adj[i]){
            if(node!=par){
                dfs1(node,i);
                count[i]+=Math.max(count[node],0);
            }
        }
        count[i]+=a[i];
    }
    static void dfs2(int i,int par,int v){
        ans[i]=count[i]+v;
        for(int node:adj[i]){
            if(node!=par)dfs2(node,i,Math.max(ans[i]-Math.max(count[node],0),0));
        }
    }
}
