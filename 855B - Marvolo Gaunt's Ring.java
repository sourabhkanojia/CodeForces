import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Sacnner(System.in);
        int n;
        long p,q,r;
        n=sc.nextInt();
        p=sc.nextLong();
        q=sc.nextLong();
        r=sc.nextLong();
        long[] a=new long[n];
        for(int i=0;i<n;i++)a[i]=sc.nextLong();

        long[] dp1=new long[n];
        long[] dp2=new long[n];
        long[] dp3=new long[n];

        dp1[0]=a[0]*p;
        for(int i=1;i<n;i++){
            dp1[i]=Long.max(dp1[i-1],a[i]*p);
        }

        dp2[0]=dp1[0]+a[0]*q;
        for(int i=1;i<n;i++){
            dp2[i]=Long.max(dp2[i-1],a[i]*q+dp1[i]);
        }

        dp3[0]=dp2[0]+a[0]*r;
        for(int i=1;i<n;i++){
            dp3[i]=Long.max(dp3[i-1],a[i]*r+dp2[i]);
        }
        System.out.println(dp3[n-1]);
    }
}
