import java.awt.*;
import java.util.*;
import java.io.*;

public class solutions {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int test=sc.nextInt();
        int P[]=new int[1000001];
        P[1]=1;
        for (int i=2;i<P.length;i++){
            if (P[i]!=0)continue;
            for (int j=i;j<P.length;j+=i){
                if (P[j]==0){
                    P[j]=i;
                }
            }
        }
        while (test-->0){
            int n=sc.nextInt(),k=sc.nextInt();
            if (n%2==0){
                long x=n;
                x+=2*k;
                System.out.println(x);
            }else {
                System.out.println((n+P[n])+2*(k-1));
            }
        }

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
}1350A - Orac and Factors	
