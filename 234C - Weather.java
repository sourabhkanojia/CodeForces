import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(new File("input.txt"));
        int n= sc.nextInt();
        int[] arr=new int[n];
        int[] dp=new int[n];
        for(int i=0;i<n;i++)arr[i]= sc.nextInt();
        for(int i=0;i<n;i++){
            if(i==0)dp[0]=arr[0]>=0?1:0;
            else dp[i]=dp[i-1]+(arr[i]>=0?1:0);
        }
        int ans=Integer.MAX_VALUE,neg=0;
        for(int i=n-1;i>0;i--){
            if(arr[i]<=0)neg++;
            ans=Math.min(ans,dp[i-1]+neg);
        }
        PrintWriter out=new PrintWriter("output.txt");
        out.println(ans);
        out.close();
    }
}
