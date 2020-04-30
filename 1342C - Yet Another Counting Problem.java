import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt(),b=sc.nextInt(),q=sc.nextInt();
            if(a>b){
                int temp=b;
                b=a;
                a=temp;
            }
            int lcm=a*b/gcd(a,b);
            int s=lcm-b;
            while(q-->0){
                long l=sc.nextLong(),r=sc.nextLong();
                long x=((l-1)/lcm)*s;
                long x1=(l-1)%lcm;
                if(x1>=b)x+=(x1-b+1);

                long y=(r/lcm)*s;
                long y1=r%lcm;
                if(y1>=b)y+=(y1-b+1);

                sb.append((y-x)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int gcd(int a,int b){
        if(b==0)return a;
        else return gcd(b,a%b);
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
