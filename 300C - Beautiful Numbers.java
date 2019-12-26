import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    static long[] fact=new long[1000001];
    public static void main(String[] args) throws Exception {
        fact[0]=1;
        for(int i=1;i<fact.length;i++){
            fact[i]=(fact[i-1]*i)%1000000007;
        }
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int n=sc.nextInt();
        long ans=0;
        for(int i=0;i<=n;i++){
            int p=a*(n-i)+b*i;
            if(check(Integer.toString(p),a,b)){
               long temp=fact[n]*(binpow(fact[n-i]*fact[i],1000000007-2,1000000007)%1000000007)%1000000007;
               ans=(ans+temp)%1000000007;
            }
        }
        System.out.println(ans);
    }
    public static boolean check(String str,int a,int b){
        char j=Integer.toString(a).charAt(0);
        char k=Integer.toString(b).charAt(0);
        for(int i=0;i<str.length();i++)if(str.charAt(i)!=j && str.charAt(i)!=k)return false;
        return true;
    }
    static long binpow(long a,  long b,  long m){
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b&1)==1)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
}
