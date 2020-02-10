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
    static  ArrayList<Edge>[] adj;
    static int[][] p;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        edges = new LinkedList[n];
        for(int i = 0; i < n; i++) edges[i] = new LinkedList<>();
        for(int i = 1; i < n; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            edges[a].add(new Edge(b, i-1));
            edges[b].add(new Edge(a, i-1));
        }
        par = new int[n];
        depth = new int[n];
        edgeid = new int[n];
        Arrays.fill(edgeid, -1);
        ret = new int[n-1];
        dfs(0, -1);
        Arrays.fill(ret, 1);
        int m = sc.nextInt();
        int[] lhs = new int[m];
        int[] rhs = new int[m];
        int[] w = new int[m];
        for(int i = 0; i < m; i++) {
            lhs[i] = sc.nextInt()-1;
            rhs[i] = sc.nextInt()-1;
            w[i] = sc.nextInt();
            int a = lhs[i];
            int b = rhs[i];
            while(a != b) {
                if(depth[a] > depth[b]) {
                    ret[edgeid[a]] = Math.max(ret[edgeid[a]], w[i]);
                    a = par[a];
                }
                else if(depth[b] > depth[a]) {
                    ret[edgeid[b]] = Math.max(ret[edgeid[b]], w[i]);
                    b = par[b];
                }
                else {
                    ret[edgeid[a]] = Math.max(ret[edgeid[a]], w[i]);
                    a = par[a];
                    ret[edgeid[b]] = Math.max(ret[edgeid[b]], w[i]);
                    b = par[b];
                }
            }
        }
        boolean good = true;
        for(int i = 0; good && i < m; i++) {
            int minw = (int)1e6;
            int a = lhs[i];
            int b = rhs[i];
            while(a != b) {
                if(depth[a] > depth[b]) {
                    minw = Math.min(minw, ret[edgeid[a]]);
                    a = par[a];
                }
                else if(depth[b] > depth[a]) {
                    minw = Math.min(minw, ret[edgeid[b]]);
                    b = par[b];
                }
                else {
                    minw = Math.min(minw, ret[edgeid[a]]);
                    a = par[a];
                    minw = Math.min(minw, ret[edgeid[b]]);
                    b = par[b];
                }
            }
            good = minw == w[i];
        }
        if(!good) System.out.println(-1);
        else {
            StringBuilder sb=new StringBuilder();
            for(int i = 0; i < ret.length; i++)sb.append(ret[i]+" ");
            System.out.println(sb);
        }
    }
    static LinkedList<Edge>[] edges;
    static int[] ret;
    static int[] par;
    static int[] depth;
    static int[] edgeid;

    public static void dfs(int curr, int p) {
        for(Edge out: edges[curr]) {
            if(out.d == p) continue;
            par[out.d] = curr;
            depth[out.d] = 1 + depth[curr];
            edgeid[out.d] = out.i;
            dfs(out.d, curr);
        }
    }
}
class Edge {
    public int d, i;
    public Edge(int a, int b) {
        d=a;
        i=b;
    }
}
