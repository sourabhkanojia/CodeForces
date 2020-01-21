import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n+1];
        for(int i=1;i<=n;i++)arr[i]=sc.nextInt();
        long[] even=new long[n];
        long[] odd=new long[n];
        for(int i=1;i<n;i++){
            odd[i]=Math.abs(arr[i]-arr[i+1])*(i%2==1?1:-1);
        }
        for(int i=2;i<n;i++){
            even[i]=Math.abs(arr[i]-arr[i+1])*(i%2==0?1:-1);
        }
        long maxg=odd[1],currg=odd[1];
        for(int i=2;i<n;i++){
            currg=Math.max(currg+odd[i],odd[i]);
            if(currg>maxg)maxg=currg;
        }
        if(n<=2){
            System.out.println(maxg);
            return;
        }
        currg=even[2];
        for(int i=3;i<n;i++){
            currg=Math.max(currg+even[i],even[i]);
            if(currg>maxg)maxg=currg;
        }
        if(currg>maxg)maxg=currg;
        System.out.println(maxg);
    }
}
