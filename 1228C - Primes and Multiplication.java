import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    static LinkedList<Integer> primes=new LinkedList<>();
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int x=sc.nextInt(); long n=sc.nextLong();
        long res=1;
        prime(x);
        for(int i:primes){
            long pow=0;
            long temp=i;
            while(true){
                pow+=(n/temp);
                if(n/temp<i)break;
                temp=temp*i;
            }
            res=(res*binpow(i,pow))%mod;
        }
        System.out.println(res);
    }
    static long binpow(long a,long b){
        a%=mod;
        long res=1;
        while(b>0){
            if((b&1)==1)res=(res*a)%mod;
            a=(a*a)%mod;
            b>>=1;
        }
        return res;
    }
    static void prime(int x){
        for(int i=2;i*i<=x;i++){
            if(x%i==0){
                primes.add(i);
                while(x%i==0)x/=i;
            }
        }
        if(x>1)primes.add(x);
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
