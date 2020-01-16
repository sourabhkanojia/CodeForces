import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),w=sc.nextInt();
        long[] arr=new long[n];
        long min=0;
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int[] sum=new int[n+w+1];
        long l=0,r=(int)1e12,ans=0;
        while(l<=r){
            Arrays.fill(sum,0);
            long mid=l+(r-l)/2;
            long temp=0;
            for(int i=0;i<n && temp<=m;i++){
                if(i>0)sum[i]+=sum[i-1];
                if(arr[i]+sum[i]<mid){
                    temp+=mid-(arr[i]+sum[i]);
                    sum[i+w]-=mid-(arr[i]+sum[i]);
                    sum[i]+=mid-(arr[i]+sum[i]);
                }
            }
            if(temp<=m){
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        System.out.println(ans);
    }
}
