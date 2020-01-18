import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int res=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(n%i==0 && n/i>=3){
                for(int j=0;j<i;j++){
                    int sum=0;
                    for(int k=j;k<n;k+=i){
                        sum+=arr[k];
                    }
                    res=Integer.max(res,sum);
                }
            }
        }
        System.out.println(res);
    }
}
