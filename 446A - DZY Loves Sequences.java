import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] l=new int[n];
        int[] r=new int[n];
        Arrays.fill(l,1);
        Arrays.fill(r,1);
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1])l[i]=l[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1])r[i]=r[i+1]+1;
        }
        int ans=Math.min(n,Math.max(l[n-1]+1,r[0]+1));
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,Math.max(l[i-1]+1,r[i+1]+1));
            if(arr[i-1]+1<arr[i+1])ans=Math.max(ans,l[i-1]+r[i+1]+1);
        }
        System.out.println(ans);
    }
}
