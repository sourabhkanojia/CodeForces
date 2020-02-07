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
    static int[][] dp;
    static int c0,d0;
    static int[] a,b,c,d;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        c0=sc.nextInt();d0=sc.nextInt();
        a=new int[m+1];b=new int[m+1];c=new int[m+1];d=new int[m+1];
        dp=new int[n+1][m+1];
        for(int[] i:dp)Arrays.fill(i,-1);
        for(int i=1;i<=m;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            c[i]=sc.nextInt();
            d[i]=sc.nextInt();
        }
        System.out.println(sol(n,m));
    }
    static int sol(int n,int m){
        if(n==0)return 0;
        if(m==0)return (n/c0)*d0;
        if(dp[n][m]!=-1)return dp[n][m];

        int ans=sol(n,m-1);
        for(int i=1;i<=n/c0;i++){
            ans=Math.max(ans,i*d0+sol(n-i*c0,m-1));
        }

        for(int i=1;i<=a[m]/b[m] && n-i*c[m]>=0;i++){
            ans=Math.max(ans,i*d[m]+sol(n-i*c[m],m-1));
        }
        return dp[n][m]=ans;
    }
}
