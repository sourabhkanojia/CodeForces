import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static HashSet<Integer>[] hr,hb;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        hr=new HashSet[n];
        hb=new HashSet[n];
        for(int i=0;i<n;i++){
            hr[i]=new HashSet<>();
            hb[i]=new HashSet<>();
        }
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            hr[u].add(v);
            hr[v].add(u);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!hr[i].contains(j)){
                    hb[i].add(j);
                    hb[j].add(i);
                }
            }
        }
        dist=new int[n];
        sol(hr);
        int ans=dist[n-1];
        sol(hb);
        ans=Math.max(dist[n-1],ans);
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    static void sol(HashSet<Integer>[] h){
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        dist[0]=0;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int node: h[u]){
                if(dist[node]>dist[u]+1){
                    dist[node]=dist[u]+1;
                    q.add(node);
                }
            }
        }
    }
}
