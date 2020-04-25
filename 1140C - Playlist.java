import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        Point[] p=new Point[n];
        for(int i=0;i<n;i++){
            p[i]=new Point(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y-o2.y;
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long ksum=0,max=0;
        for(int i=n-1;i>=0;i--){
            if(i>=n-k){
                ksum+=p[i].x;
                pq.add(p[i].x);
                max=Math.max(max,ksum*p[i].y);
            }
            else{
                int min=pq.remove();
                ksum-=min;
                ksum+=p[i].x;
                pq.add(p[i].x);
                max=Math.max(max,ksum*p[i].y);
            }
        }
        System.out.println(max);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
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
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
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
