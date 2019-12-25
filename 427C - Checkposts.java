import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*In this problem we have to find Strongly Connected Component with the help of Kosaraju-Sharir Algorithm. And then
sum of minimum cost of each component and for calculating ways we have to multiplies how many times that minimums occur in their
component. */
public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            g.addEdge(u, v);
        }
        g.kosaRaju();
        Node[] node=new Node[n];
        for(int i=0;i<n;i++){
            node[i]=new Node(arr[i],g.set[i]);
        }
        Arrays.sort(node);
        long ways=1;
        long cost=0;
        int x=-1;
        int count=1;
        int min=0;
        for(int i=0;i<n;i++){
            if(node[i].com>x){
                x=node[i].com;
                min=node[i].value;
                cost+=min;
                ways=(ways*count)%1000000007;
                count=1;
            }
            else if(min==node[i].value){
                count++;
            }
        }
        ways=(ways*count)%1000000007;
        System.out.println(cost+" "+ways);
    }
    static class Graph {
        int v;
        boolean[] visited;
        int[] set;
        LinkedList<Integer>[] ll, reverse;
        int i = 0;

        public Graph(int v) {
            this.v = v;
            visited = new boolean[v];
            ll = new LinkedList[v];
            reverse = new LinkedList[v];
            set = new int[v];
            for (int i = 0; i < v; i++) {
                ll[i] = new LinkedList<>();
                reverse[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            ll[u].add(v);
            reverse[v].add(u);
        }

        Stack<Integer> stack = new Stack<>();

        public void kosaRaju() {
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            Arrays.fill(set, -1);

            while (!stack.isEmpty()) {
                int x = stack.pop();
                if (set[x] == -1) {
                    set[x] = i;
                    dfsReverse(x, i++);
                }

            }
        }

        public void dfs(int src) {
            visited[src] = true;
            for (int i : ll[src]) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            stack.push(src);
        }

        public void dfsReverse(int src, int i) {
            for (int j : reverse[src]) {
                if (set[j] == -1) {
                    set[j] = i;
                    dfsReverse(j, i);
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int value,com;
    public Node(int value,int com){
        this.value=value;
        this.com=com;
    }
    public int compareTo(Node o){
        if(this.com==o.com){
            return this.value-o.value;
        }
        else return this.com-o.com;
    }
}
