import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        long fact[]=new long[1000001];
        fact[0]=1;
        for (int i=1;i<=1000;i++)fact[i]=(i*fact[i-1])%mod;
        int k=sc.nextInt();
        int[] arr=new int[k];
        int sum=0;
        for(int i=0;i<k;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        long ans=1;

        for(int i=k-1;i>=1;i--){
            long temp=(fact[sum-1]*binpow((fact[arr[i]-1]*fact[(sum-1)-(arr[i]-1)])%mod,mod-2))%mod;
            ans=(ans*temp)%mod;
            sum-=arr[i];
        }
        System.out.println(ans);
    }
    static long binpow(long a,  long b){
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b&1)==1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res%mod;
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
