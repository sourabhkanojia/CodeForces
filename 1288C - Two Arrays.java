import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        long fact[]=new long[10000];
        fact[0]=1;
        for (int i=1;i<10000;i++){
            fact[i]=(i*fact[i-1])%mod;
        }
        for(int i=1;i<10000;i++)fact[i]=(i*fact[i-1])%mod;
        int n=sc.nextInt(),m=sc.nextInt();
        System.out.println((fact[n+2*m-1]*(binpow((fact[2*m]*fact[n-1])%mod,mod-2)))%mod);
    }
    static long binpow(long a,  long b){
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b&1)==1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
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
