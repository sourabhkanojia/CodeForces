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
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            if(x!=-1){
                g.addEdge(i,x-1,true);
            }
            else arr.add(i);
        }
 
 
        for(int i=0;i<arr.size();i++){
            g.bfs(arr.get(i));
        }
 
 
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)set.add(g.dist[i]);
        System.out.println(set.size());
 
    }
 
    static class graph {
 
        int v;
        LinkedList<Integer>[] ll;
 
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
