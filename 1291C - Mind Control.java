import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (t-->0) {
            int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            k=Math.min(k,m-1);
            int ans=0;
            for(int i=0;i<=k;i++){
                int min=Integer.MAX_VALUE;
                for(int j=0;j<=m-1-k;j++){
                    int x=m-1-(i+j);
                    min=Math.min(min,Math.max(arr[i+j],arr[n-1-x]));
                }
                ans=Math.max(ans,min);
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
