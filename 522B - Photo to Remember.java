import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        Point[] p=new Point[n];
        int sum=0;
        TreeSet<Integer> treeSet=new TreeSet<>();
        int[] heights=new int[1001];
        for(int i=0;i<n;i++){
            p[i]=new Point(sc.nextInt(),sc.nextInt());
            sum+=p[i].x;
            treeSet.add(p[i].y);
            heights[p[i].y]++;
        }
        for(int i=0;i<n;i++){
            if(heights[p[i].y]>1){
                sb.append((sum-p[i].x)*treeSet.last());
            }
            else{
                if(treeSet.higher(p[i].y)==null){
                    sb.append((sum-p[i].x)*treeSet.lower(p[i].y));
                }
                else sb.append((sum-p[i].x)*treeSet.last());
            }
            sb.append(" ");
        }
        System.out.println(sb);
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
