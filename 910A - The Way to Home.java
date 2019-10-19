import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        String s=sc.nextLine();
 
        int[] dp=new int[s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
 
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1'){
                int min=Integer.MAX_VALUE;
                for(int j=1;j<=d && i-j>=0 ;j++){
                    if(s.charAt(i-j)=='1'){
                        if(dp[i-j]<min)min=dp[i-j];
                    }
                }
                if(min!=Integer.MAX_VALUE){
                    dp[i]=min;
                    dp[i]++;
                }
            }
        }
        if(dp[n-1]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n-1]);
    }
}
