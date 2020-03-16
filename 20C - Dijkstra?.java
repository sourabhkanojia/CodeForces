import java.awt.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        LinkedList<Point>[] ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1,w=sc.nextInt();
            ll[u].add(new Point(v,w));
            ll[v].add(new Point(u,w));
        }
        boolean[] vis=new boolean[n];
        int[] parent=new int[n];
        int[] dist=new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Point> pq=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y-o2.y;
            }
        });
        dist[0]=0;
        pq.add(new Point(0,0));
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(!vis[p.x]){
                vis[p.x]=true;
                for(Point node:ll[p.x]){
                    if(!vis[node.x]){
                        if(dist[node.x]>dist[p.x]+node.y){
                            dist[node.x]=dist[p.x]+node.y;
                            parent[node.x]=p.x;
                            pq.add(new Point(node.x,dist[node.x]));
                        }
                    }
                }
            }
        }
        LinkedList<Integer> path=new LinkedList<>();
        int temp=n-1;
        while(temp!=-1){
            path.addFirst(temp+1);
            temp=parent[temp];
        }
        if(path.getFirst()==1 && path.getLast()==n){
            for(int i:path)sb.append(i+" ");
            System.out.println(sb);
        }
        else System.out.println(-1);
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
