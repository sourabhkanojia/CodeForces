import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
        char[][] arr=new char[n][m];
        for(int i=0;i<n;i++)arr[i]=sc.next().toCharArray();
        int[] sum=new int[m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)if(arr[i][j]=='#')sum[j+1]++;
        }
        for(int i=1;i<=m;i++)sum[i]+=sum[i-1];
        int[][] dp=new int[2][m+1];
        for(int[] i:dp)Arrays.fill(i,(int)1e9);
        dp[0][0]=dp[1][0]=0;
        for(int i=0;i<m;i++){
            for(int j=x;j<=y;j++){
                if(i+j>m)break;
                dp[0][i+j]=Integer.min(dp[0][i+j],dp[1][i]+sum[i+j]-sum[i]);
                dp[1][i+j]=Integer.min(dp[1][i+j],dp[0][i]+n*j-(sum[i+j]-sum[i]));
            }
        }
        System.out.println(Integer.min(dp[0][m],dp[1][m]));

    }
}
