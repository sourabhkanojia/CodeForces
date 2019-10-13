import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++)a[i]=sc.nextInt();
        int[][] dp=new int[n+1][3];

        for(int i=1;i<=n;i++){
            dp[i][0]=200;
            dp[i][1]=200;
            dp[i][2]=200;
        }

        if(a[1]==1){
            dp[1][0]=1;
            dp[1][1]=0;
        }
        else if(a[1]==2){
            dp[1][0]=1;
            dp[1][2]=0;
        }
        else if(a[1]==0)dp[1][0]=1;
        else{
            dp[1][0]=1;
            dp[1][1]=0;
            dp[1][2]=0;
        }
        for(int i=2;i<=n;i++){
            if(a[i]==0) dp[i][0]=1+min(dp[i-1][0],dp[i-1][1],dp[i-1][2]);
            else if(a[i]==1){
                dp[i][0]=1+min(dp[i-1][0],dp[i-1][1],dp[i-1][2]);
                dp[i][1]=Integer.min(dp[i-1][0],dp[i-1][2]);
            }
            else if(a[i]==2){
                dp[i][0]=1+min(dp[i-1][0],dp[i-1][1],dp[i-1][2]);
                dp[i][2]=Integer.min(dp[i-1][1],dp[i-1][0]);
            }
            else{
                dp[i][1]=Integer.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2]=Integer.min(dp[i-1][1],dp[i-1][0]);
            }
        }
        System.out.println(min(dp[n][0],dp[n][1],dp[n][2]));
    }
    public static int min(int a,int b,int c){
        if(a<=b && a<=c)return a;
        else if(b<=a && b<=c)return b;
        else return c;
    }
}
