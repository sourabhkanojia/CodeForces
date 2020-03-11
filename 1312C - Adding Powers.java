import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), k = sc.nextInt();
            long[] arr = new long[n];
            byte[] count=new byte[64];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
            boolean z=false;

            for(int i=0;i<n;i++){
                int c=0;
                while(arr[i]!=0){
                    if(arr[i]%k>1)z=true;
                    if(arr[i]%k!=0)count[c]++;
                    if(count[c]>1)z=true;
                    c++;
                    arr[i]/=k;
                }
                if(z)break;
            }
            if(z)sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
