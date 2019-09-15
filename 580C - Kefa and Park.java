import java.awt.dnd.Autoscroll;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
 
 
public class Main {
 
    public static void main(String[] args) throws IOException,NullPointerException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        graph g=new graph(n);
        int m=sc.nextInt();
 
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i=0;i<n-1;i++){
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
            g.addEdge(x-1,y-1,true);
        }
 
        g.dfs(0,a,m,0);
 
        System.out.println(g.sol);
 
    }
 
    static class graph {
 
        int v;
        LinkedList<Integer>[] ll;
 
        int sol;
        boolean[] visited;
        int[] dist;
        int[] parent;
 
        public graph(int v) {
            this.v = v;
            ll = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                ll[i] = new LinkedList<>();
            }
            visited=new boolean[v];
            dist=new int[v];
            parent=new int[v];
 
 
        }
 
        public void addEdge(int u, int v, boolean x) {
            ll[u].add(v);
            if (x) ll[v].add(u);
 
        }
 
        void dfs(int src,int[] a,int m,int x){
            int count=x;
//            System.out.print(src+"->");
            visited[src]=true;
 
            if(a[src]==1){
                if(count<m) count++;
                else return;
            }
            else count=0;
 
 
            if(ll[src].size()==1 && src!=0){
                sol++;
                return;
            }
 
            for(int w:ll[src]){
 
                if(!visited[w]){
                    dfs(w,a,m,count);
                }
            }
        }
 
        void bfs(int src) {
 
            LinkedList<Integer> q = new LinkedList<>();
            q.push(src);
            Arrays.fill(parent, -1);
            visited[src] = true;
 
            while (!q.isEmpty()) {
                int node = q.pop();
//                System.out.print(node+"->");
                for (int neighbour : ll[node]) {
                    if (!visited[neighbour]) {
                        q.add(neighbour);
                        visited[neighbour] = true;
                        dist[neighbour] = dist[node] + 1;
                        parent[neighbour] = node;
 
                    }
                }
            }
//            System.out.println();
 
 
//            int temp = dest;
//            while (temp != -1) {
//                System.out.print(temp + "<--");
//                temp = parent[temp];
//            }
//            System.out.println();
        }
 
        public void printlist() {
            for (int i = 0; i < ll.length; i++) {
                System.out.println(i + "->" + ll[i]);
            }
        }
 
        public Iterable<Integer> adj(int v) {
            return ll[v];
        }
        public void printDist(){
            for(int i=0;i<v;i++){
                System.out.println(i+"->"+dist[i]);
            }
        }
 
    }
}
