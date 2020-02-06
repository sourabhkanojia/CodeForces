import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long k=sc.nextLong();
        if(n==1){
            System.out.println(0);
            return;
        }
        if(n<=k){
            System.out.println(1);
            return;
        }
        long l=2,r=k,ans=-1,out=k*(k+1)/2;
        out-=k;
        while(l<=r){
            long mid=l+(r-l)/2;
            long temp=out-((mid*(mid-1)/2)-mid);
            if(temp>=n){
                ans=k-(mid-1);
                l=mid+1;
            }
            else r=mid-1;
        }
        System.out.println(ans);
    }
}
