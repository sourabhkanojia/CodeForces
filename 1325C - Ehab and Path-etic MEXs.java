import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuffer sb = new StringBuffer();
        int n=sc.nextInt();
        LinkedList<Integer>[] ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        Point[] edges=new Point[n-1];
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            ll[u].add(v);
            ll[v].add(u);
            edges[i]=new Point(u,v);
        }
        HashMap<Point,Integer> hm=new HashMap<>();
        int temp=0;
        boolean z=false;
        for(int i=0;i<n;i++){
            if(ll[i].size()>2){
                z=true;
                for(int node:ll[i]){
                    hm.put(new Point(i,node),temp);
                    hm.put(new Point(node,i),temp);
                    temp++;
                    if(temp==3)break;
                }
            }
            if(z)break;
        }

        if(!z){
            for(int i=0;i<n-1;i++)sb.append(i+"\n");
        }
        else{
            for(int i=0;i<n-1;i++){
                if(hm.containsKey(edges[i])){
                    sb.append(hm.get(edges[i])+"\n");
                }
                else sb.append((temp++)+"\n");
            }
        }
        System.out.println(sb);
    }

    static class FastReader {
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
}
