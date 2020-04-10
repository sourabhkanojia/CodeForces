import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Point[] p=new Point[n];
            for(int i=0;i<n;i++)p[i]=new Point(sc.nextInt(),sc.nextInt());
            int e=0,c=0;
            boolean z=true;
            for(int i=0;i<n;i++){
                if(i==0){
                    if(p[i].x<p[i].y){
                        z=false;
                        break;
                    }
                }
                else{
                    if((p[i].x<p[i].y) || p[i].x<p[i-1].x || p[i].y<p[i-1].y || (p[i].x-p[i-1].x)<(p[i].y-p[i-1].y)){
                        z=false;
                        break;
                    }
                }
            }
            if(z)sb.append("YES\n");
            else sb.append("NO\n");
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
