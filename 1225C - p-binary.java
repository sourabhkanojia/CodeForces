import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        long n=sc.nextInt(),p=sc.nextInt();
        for(long i=1;i<1000;i++){
            n-=p;
            if(n<=0){
                System.out.println(-1);
                return;
            }
            long temp=n;
            int count=0;
            while(temp>0){
                if((temp&1)==1)count++;
                temp>>=1;
            }
            if(count<=i && i<=n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
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
