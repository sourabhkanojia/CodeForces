import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        long[][] dp=new long[k+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=k;i++){                                  _________________________
            for(int j=1;j<=n;j++){                             | | 1 | 2 | 3 | 4 | 5 | 6 |
                for(int x=j;x<=n;x+=j){                           ------------------------
                                                               |1| 1   1   1   1   1   1
                   dp[i][j]=(dp[i][j]+dp[i-1][x])%1000000007;  |2| 6   3   2   1   1   1
                }                                              |3| 14  5   3   1   1   1
            }                                                  |4| 25  7   4   1   1   1  Total good sequences of length 4 =25+7+4+1+1+1=39        }                                                         
        long ans=0;                                             
        for(int i=1;i<=n;i++){
            ans+=dp[k][i];
        }
        System.out.println(ans%1000000007);
    }
}
