import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int l=0,r=dp.length-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(dp[mid]<=arr[i]){
                    l=mid+1;
                }
                else r=mid-1;
            }
            dp[l]=arr[i];
        }
        int count=1;
        while(count<=n && dp[count]!=Integer.MAX_VALUE)count++;
        System.out.println(count-1);
    }
}
