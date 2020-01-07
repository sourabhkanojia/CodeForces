import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanne sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        long[] arr=new long[n+1];
        for(int i=1;i<=n;i++)arr[i]=arr[i-1]+sc.nextLong();
        long[][] dp=new long[k+1][n+1];
        for(int i=1;i<=k;i++){
            for(int j=m;j<=n;j++)dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j-m]+arr[j]-arr[j-m]);
        }
        System.out.println(dp[k][n]);
    }
}
