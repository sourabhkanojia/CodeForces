import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[] dp=new int[n];
        int[] count=new int[100001];
        Edge[] e=new Edge[m];
        for(int i=0;i<m;i++){
            int w;
            e[i]=new Edge(sc.nextInt()-1,sc.nextInt()-1,w=sc.nextInt());
            count[w]++;
        }
        Arrays.sort(e);
        for(int i=0;i<m;i++){
            int w=e[i].w;
            int cnt=count[w];
            int[] ans=new int[cnt];
            for(int j=0;j<cnt;j++){
                int x=e[i+j].u;
                int y=e[i+j].v;
                ans[j]=Math.max(dp[y],dp[x]+1);
            }
            for(int j=0;j<cnt;j++){
                int y=e[i+j].v;
                dp[y]=Math.max(dp[y],ans[j]);
            }
            i+=cnt-1;
        }
        int max=0;
        for(int i=0;i<n;i++)max=Math.max(max,dp[i]);
        System.out.println(max);
    }
}
class Edge implements Comparable<Edge>{
    int u,v,w;
    Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }

    public int compareTo(Edge o) {return this.w-o.w; }
}
