import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    static long max=0;
    static LinkedList<Edge>[] ll;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        long sum=0;
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1,w=sc.nextInt();
            ll[u].add(new Edge(v,w));
            ll[v].add(new Edge(u,w));
            sum+=w;
        }
        dfs(0,0,0);
        System.out.println(max+(sum-max)*2);
    }
    static void dfs(int i,int parent,long total){
        max=Math.max(max,total);
        for(Edge node:ll[i]){
            if(node.v!=parent){
                dfs(node.v,i,total+node.w);
            }
        }
    }
}
class Edge{
    int v,w;
    Edge(int v,int w){
        this.v=v;this.w=w;
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
