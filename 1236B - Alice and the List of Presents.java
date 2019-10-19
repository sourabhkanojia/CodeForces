import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();          // Number Of Ways -> ((2^m)-1)^n
 
        long sum=0;
        sum=binpow(2,m,1000000007);
        sum=sum-1;
        sum=binpow(sum,n,1000000007);
        System.out.println(sum);
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
