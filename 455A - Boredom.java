import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a=new long[100001];
        long[] dp=new long[100001];
 
        for(int i=0;i<n;i++){
            a[sc.nextInt()]++;
        }
        dp[0]=0;
        dp[1]=a[1];
 
        for(int i=2;i<=100000;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+a[i]*(long)i);
        }
        System.out.println(dp[100000]);
    }
 
}
