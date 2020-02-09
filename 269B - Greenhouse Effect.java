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
        int n=sc.nextInt(),m=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sc.nextDouble();
        }
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i])dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(n-max);
    }
}
