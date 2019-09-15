import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int n,k;
        str=new StringTokenizer(br.readLine());
        n=Integer.parseInt(str.nextToken());
        k=Integer.parseInt(str.nextToken());
        int[] a=new int[n];
        str=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)a[i]=Integer.parseInt(str.nextToken());
        int min=0;
        int sum=0;
        int j;
        for(int i=0;i<k;i++){
            sum=sum+a[i];
        }
        min=sum;
        j=0;
 
        for(int i=1;i<n-k+1;i++){
            sum=sum-a[i-1]+a[i+k-1];
            if(sum<min){
                min=sum;
                j=i;
            }
        }
 
        System.out.println(j+1);
 
    }
}
