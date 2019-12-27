import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception,ArithmeticException {
        FastReader sc = new FastReader();
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] c = new int[v];
        boolean[] present=new boolean[100001];
        for (int i = 0; i < v; i++){
            c[i] = sc.nextInt();
            present[c[i]]=true;
        }
        Graph g = new Graph(v);
        for (int i = 1; i <= e; i++) g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
        HashSet<Integer>[] hs = new HashSet[100001];
        for (int i = 0; i < 100001; i++) hs[i] = new HashSet<>();
        for (int i = 0; i < v; i++) {
            for(int j:g.ll[i]){
                if(c[i]!=c[j]){
                    hs[c[i]].add(c[j]);
                }
            }
        }
        int color = -1;
        int max = -1;
        for(int i=0;i<100001;i++){
            if(present[i]) {
                if (hs[i].size() > max) {
                    max = hs[i].size();
                    color = i;
                }
            }
        }
        System.out.println(color);

    }
}
class Graph{
    int v;
    LinkedList<Integer>[] ll;
    public Graph(int v){
        this.v=v;
        ll=new LinkedList[v];
        for(int i=0;i<v;i++)ll[i]=new LinkedList<>();
    }
    public void addEdge(int u,int v){
        ll[u].add(v);
        ll[v].add(u);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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

