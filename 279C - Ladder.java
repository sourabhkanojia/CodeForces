import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        int[] dp_inc=new int[n],dp_dec=new int[n];
        dp_inc[0]=dp_dec[n-1]=1;
        for(int i=1;i<n;i++){
            if(a[i]<=a[i-1])dp_inc[i]=dp_inc[i-1]+1;
            else dp_inc[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(a[i]<=a[i+1])dp_dec[i]=dp_dec[i+1]+1;
            else dp_dec[i]=1;
        }

        while(m-->0){
            int l=sc.nextInt()-1,r=sc.nextInt()-1;
            System.out.println(dp_dec[l]+dp_inc[r]>r-l+1?"Yes":"No");
        }
    }
}
