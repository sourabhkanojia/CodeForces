import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        long n=sc.nextLong(),b=sc.nextLong();
        long ans=Long.MAX_VALUE;
        for(long i=2;i*i<=b;i++){
            int cnt=0;
            while(b%i==0){
                cnt++;
                b/=i;
            }
            if(cnt>0){
                ans=Math.min(get(n,i)/cnt,ans);
            }
        }
        if(b!=1){
            ans=Math.min(get(n,b),ans);
        }
        System.out.println(ans);
    }
    static long get(long n,long x){
        long ans=0;
        while(n>0){
            n/=x;
            ans+=n;
        }
        return ans;
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
