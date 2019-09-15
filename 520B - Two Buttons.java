import java.awt.dnd.Autoscroll;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int count=0;
        while(b>a){
            if((b&1)==1) {
                count++;
                b++;
            }
            else {
                b=b/2;
                count++;
            }
        }
        System.out.println(count+(a-b));
    }
}
 
class graph {
 
    int v;
    LinkedList<Integer>[] ll;
 
    public graph(int v) {
        this.v = v;
        ll = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            ll[i] = new LinkedList<>();
        }
    }
 
    public void addEdge(int u,int v,boolean x){
        ll[u].add(v);
        if(x)ll[v].add(u);
 
    }
    void bfs(int src,int dest){
        LinkedList<Integer> q=new LinkedList<>();
        q.push(src);
 
        boolean[] visited=new boolean[v];
        visited[src]=true;
        int[] dist=new int[v];
        int[] parent=new int[v];
        Arrays.fill(parent,-1);
 
        while(!q.isEmpty()){
            int node=q.pop();
            System.out.print(node+" ");
 
            for(int neighbour:ll[node]){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour]=true;
                    dist[neighbour]=dist[node]+1;
                    parent[neighbour]=node;
                }
            }
        }
        System.out.println();
 
 
        int temp=dest;
        while(temp!=-1){
            System.out.print(temp+"<--");
            temp=parent[temp];
        }
        System.out.println();
    }
    public void printlist(){
        for(int i=0;i<ll.length;i++){
            System.out.println(i+"->"+ll[i]);
        }
    }
    public Iterable<Integer> adj(int v){
        return ll[v];
    }
 
}
