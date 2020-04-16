import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt(),n=sc.nextInt(),m=sc.nextInt();
            boolean z=true;
            while(true){
                if(x>0 && x<=20 && m==0){
                    z=false;
                    break;
                }
                if(x<=0)break;
                if(m==0){
                    z=false;
                    break;
                }
                if(n==0 || x<=20){
                    x-=10;
                    m--;
                }
                else{
                    x=(x/2)+10;
                    n--;
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
