import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception {
         Scanner sc=new Scanner(System.in);
         int v=sc.nextInt();
         int e=sc.nextInt();
         node[] energy=new node[v];
         int[] copy=new int[v];
         
         for(int i=0;i<v;i++){
             int input=sc.nextInt();
             energy[i]=new node(input,i);
             copy[i]=input;
         }
         
         graph g=new graph(v);
         for(int i=1;i<=e;i++){
             g.addEdge(sc.nextInt()-1,sc.nextInt()-1);
         }

         int sol=0;

        Arrays.sort(energy);

        HashSet<Integer> hs=new HashSet<>();
        for(int i=v-1;i>=0;i--){
            int index=energy[i].index;
            hs.add(index);
            for(int j:g.ll[index]){
                if(!hs.contains(j))sol=sol+copy[j];
            }
        }
        System.out.println(sol);
    }
}
class graph {
    int v;
    LinkedList<Integer>[] ll;
    boolean[] visited;

    public graph(int v) {
        this.v=v;
        ll=new LinkedList[v];
        for(int i=0;i<v;i++)ll[i]=new LinkedList<Integer>();
        visited=new boolean[v];
    }
    public void addEdge(int u,int v){
        ll[u].add(v);
        ll[v].add(u);
    }
    public void printList(){
        for(int i=0;i<v;i++){
            System.out.println(i+"->"+ll[i]);
        }
    }
}
class node implements Comparable<node>{
    int value;
    int index;
    public node(int value,int index){
        this.value=value;
        this.index=index;
    }

    public int compareTo(node o) {
        return this.value-o.value;
    }
}
