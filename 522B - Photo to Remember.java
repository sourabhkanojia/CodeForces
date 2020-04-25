import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        Point[] p=new Point[n];
        int sum=0,max=0,max2=0;
        for(int i=0;i<n;i++){
            p[i]=new Point(sc.nextInt(),sc.nextInt());
            sum+=p[i].x;
            max=Math.max(max,p[i].y);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(max!=p[i].y){
                max2=Math.max(max2,p[i].y);
            }
            else count++;
        }
        if(count>1)max2=max;
        for(int i=0;i<n;i++){
            if(p[i].y==max){
                sb.append((sum-p[i].x)*max2);
            }
            else sb.append((sum-p[i].x)*max);
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
