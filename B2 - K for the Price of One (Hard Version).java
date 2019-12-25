import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int k = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);
            Integer[] dp=new Integer[n+1];
            dp[0]=0;
            for(int i=1;i<k;i++){
                dp[i]=dp[i-1]+arr[i-1];
            }
            for(int i=k;i<=n;i++){
                dp[i]=arr[i-1]+Math.min(dp[i-1],dp[i-k]);
            }
            for(int i=n;i>=0;i--){
                if(p>=dp[i]){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
