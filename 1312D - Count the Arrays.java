import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        long[] fact=new long[m+1];
        fact[0]=1;
        for(int i=1;i<fact.length;i++){
            fact[i]=(fact[i-1]*i)%998244353;
        }
        long sol=0;
        long x=pow(fact[m-n+1]*fact[n-1],998244353-2);
        long temp=(fact[m]*x)%998244353;
        sol+=((temp*(n-2))%998244353*(pow(2,n-3)))%998244353;
        sol=sol%998244353;

        System.out.println(sol);
    }
    static long pow(long a,long b){
        a=a%998244353;
        long res=1;
        while(b>0){
            if((b&1)==1){
                res=(res*a)%998244353;
            }
            a=(a*a)%998244353;
            b>>=1;
        }
        return res;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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
}
