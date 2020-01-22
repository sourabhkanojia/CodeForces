import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong(),m=sc.nextLong(),k=sc.nextLong();
        long l=1,r=n*m;
        while(l<r){
            long mid=(l+r)>>1;
            if(k<=check(mid,n,m))r=mid;
            else l=mid+1;
        }
        System.out.println(r);
    }
    static long check(long mid,long n,long m){
        long sum=0;
        for(int i=1;i<=n;i++){
            sum+=Math.min(mid/i,m);
        }
        return sum;
    }
}
