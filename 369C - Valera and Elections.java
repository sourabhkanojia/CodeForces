import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    static HashMap<String,Integer> hm=new HashMap<>();
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int v=sc.nextInt();
        graph g=new graph(v);
        for(int i=0;i<v-1;i++){
            int x=sc.nextInt()-1,y=sc.nextInt()-1,z=sc.nextInt();
            g.addEdge(x,y);
            hm.put(x+" "+y,z);
        }
        g.dfs(-1,0);
        System.out.println(g.hs.size());
        for(int i:g.hs) System.out.print(i+1+" ");
    }
    static class graph{
        int v;
        LinkedList<Integer>[] ll;
        HashSet<Integer> hs=new HashSet<>();
        public graph(int v){
            this.v=v;
            ll=new LinkedList[v];
            for(int i=0;i<v;i++)ll[i]=new LinkedList<>();
        }
        public void addEdge(int u,int v){
            ll[u].add(v);
            ll[v].add(u);
        }
        public int dfs(int parent,int node){
            if(ll[node].size()==0){
                if((hm.containsKey(parent+" "+node) && hm.get(parent+" "+node)==2)||(hm.containsKey(node+" "+parent) && hm.get(node+" "+parent)==2)) {
                    hs.add(node);
                    return 1;
                }
                else return 0;
            }
            int pass=0;
            for(int i:ll[node]){
                if(i==parent)continue;
                int x=dfs(node,i);
                if(x==1)pass=1;
            }
            if((hm.containsKey(parent+" "+node) && hm.get(parent+" "+node)==2)||(hm.containsKey(node+" "+parent) && hm.get(node+" "+parent)==2)){
                if(pass!=1)hs.add(node);
                return 1;
            }
            else return pass;
        }
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
