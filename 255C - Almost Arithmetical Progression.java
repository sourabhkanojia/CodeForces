import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int dp[][];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++)arr[i]=sc.nextInt();
        int res=1;
        for(int i=1;i<=n;i++){
            int k=0;
            for(int j=0;j<i;j++){
                dp[i][j] = Math.max(dp[i][j], dp[j][k]+1);
                if(arr[j]==arr[i]) k=j;
                res=Math.max(res,dp[i][j]);
            }
        }
        System.out.println(res);
    }
}
