import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            long a=sc.nextLong(),m=sc.nextLong();
            a=m/gcd(a,m);
            sb.append(eulerT(a)+"\n");
        }
        System.out.println(sb);
    }
    static long gcd(long a,long b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }
    static long eulerT(long m){
        long res=m;
        for(long i=2;i*i<=m;i++){
            if(m%i==0){
                res=res-res/i;
                while(m%i==0)m/=i;
            }
        }
        if(m>1)res-=res/m;
        return res;
    }
}
