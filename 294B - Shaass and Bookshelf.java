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
        int n=sc.nextInt();
        int[] t=new int[n+1];
        int[] w=new int[n+1];
        for(int i=1;i<=n;i++){
            t[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][201];
        for(int[] i:dp)Arrays.fill(i,1000);
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<201;j++){
                if(j-t[i]>=0)dp[i][j]=Math.min(dp[i-1][j]+w[i],dp[i-1][j-t[i]]);
                else dp[i][j]=dp[i-1][j]+w[i];
            }
        }
        for(int i=1;i<201;i++){
            if(dp[n][i]<=i){
                System.out.println(i);
                return;
            }
        }
    }
}
