import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] fact=new int[100004];
        Arrays.fill(fact,-1);
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=1;j*j<=arr[i];j++){
                if(arr[i]%j==0){
                    if(fact[j]!=-1 && j!=1)dp[i]=Math.max(dp[i],dp[fact[j]]+1);
                    if(fact[arr[i]/j]!=-1 && arr[i]/j!=1)dp[i]=Math.max(dp[i],dp[fact[arr[i]/j]]+1);
                    res=Math.max(res,dp[i]);
                    fact[j]=i;
                    fact[arr[i]/j]=i;
                }
            }
        }
        System.out.println(res);
    }
}
