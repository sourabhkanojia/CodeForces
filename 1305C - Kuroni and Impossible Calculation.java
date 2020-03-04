import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        if(n>m) System.out.println(0);
        else{
            long ans=1;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    ans=(ans*Math.abs(arr[j]-arr[i]))%m;
                }
            }
            System.out.println(ans);
        }
    }
}
