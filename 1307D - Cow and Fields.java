import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int[] spec=new int[k];
        for(int i=0;i<k;i++)spec[i]=sc.nextInt()-1;
        ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            ll[u].add(v);
            ll[v].add(u);
        }
        int[] dist1=new int[n];
        bfs(dist1,0);
        int[] distn=new int[n];
        bfs(distn,n-1);
        Arrays.sort(spec);
        Point[] p=new Point[k];
        for(int i=0;i<k;i++){
            p[i]=new Point(dist1[spec[i]]-distn[spec[i]],spec[i]);
        }
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x-o2.x;
            }
        });
        int best=0,max=Integer.MIN_VALUE;

        for(int i=0;i<k-1;i++){
            best=Math.max(best,dist1[p[i].y]+distn[p[i+1].y]);
        }
        System.out.println(Math.min(dist1[n-1],best+1));
    }
    static void bfs(int[] dist,int src){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(src);
        boolean[] vis=new boolean[dist.length];
        vis[src]=true;
        while(!queue.isEmpty()){
            int node=queue.remove();
            for(int i:ll[node]){
                if(!vis[i]){
                    vis[i]=true;
                    queue.add(i);
                    dist[i]=dist[node]+1;
                }
            }
        }

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
