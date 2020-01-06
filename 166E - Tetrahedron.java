import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class test {
    static int mod=(int)1e9+7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[][] dp=new long[2][n+1];
        dp[1][0]=1;                        //D represent by 1 -> We can reach to D by 3 states(A,B,C).
        dp[0][0]=0;                        //A,B,C represent by 0 -> We can reach to A or B or C by D + by two other same states.
        for(int i=1;i<=n;i++){
            dp[1][i]=(3*dp[0][i-1]%mod)%mod;
            dp[0][i]=(2*dp[0][i-1]%mod)%mod +dp[1][i-1];
        }
        System.out.println(dp[1][n]);
    }
}
