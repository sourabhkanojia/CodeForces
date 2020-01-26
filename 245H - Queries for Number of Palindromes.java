import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        s=" "+s;
        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++)dp[i][i]=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i+1))dp[i][i+1]=1;
        }
        for(int len=0;len<n-2;len++){
            for(int i=1;i<n-len;i++){
                if(dp[i][i+len]==1 && s.charAt(i-1)==s.charAt(i+len+1)){
                    dp[i-1][i+len+1]=1;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)dp[i][j]+=dp[i][j-1];
        }
        for(int j=1;j<=n;j++){
            for(int i=1;i<=n;i++)dp[i][j]+=dp[i-1][j];
        }

        StringBuilder sb=new StringBuilder();
        int q=sc.nextInt();
        while(q-->0){
            int a=sc.nextInt(),b=sc.nextInt();
            sb.append(dp[b][b]-dp[b][a-1]-dp[a-1][b]+dp[a-1][a-1]+"\n");
        }
        System.out.println(sb);
    }
}
