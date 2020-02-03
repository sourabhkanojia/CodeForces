import javax.print.attribute.standard.PrintQuality;
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
        String s=sc.next();
        int n=s.length();
        s=" "+s;
        int[][] dp=new int[s.length()][s.length()];
        int[] count=new int[s.length()];
        for(int i=1;i<=n;i++)dp[i][i]=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i+1))dp[i][i+1]=1;
        }
        for(int len=0;len<n-2;len++){
            for(int i=1;i<n-len;i++){
                if(dp[i][i+len]!=0 && s.charAt(i-1)==s.charAt(i+len+1)){
                    dp[i-1][i+len+1]=1;
                }
            }
        }
        for(int i=1;i<n;i++){
            int temp=0;
            for(int j=i;j>=1;j--){
                temp+=dp[j][i];
            }
            count[i]=temp;
        }
        for(int j=2;j<=n;j++){
            for(int i=1;i<=n;i++){
                dp[i][j]+=dp[i][j-1];
            }
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]+=dp[i-1][j];
            }
        }
        long res=0;
        for(int i=1;i<n;i++){
            res+=count[i]*(dp[n][n]-dp[n][i]-dp[i][n]+dp[i][i]);
        }
        System.out.println(res);
    }
}
