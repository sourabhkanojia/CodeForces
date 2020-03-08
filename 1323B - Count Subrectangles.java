import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[m];
        for (int i=0;i<n;i++)a[i]=sc.nextInt();
        for (int i=0;i<m;i++)b[i]=sc.nextInt();
        int suma[]=new int[n];
        int sumb[]=new int[m];
        suma[0]=a[0];
        sumb[0]=b[0];
        for (int i=1;i<n;i++){
            if (a[i]==1){
                suma[i]=suma[i-1]+1;
            }
        }
        for (int i=1;i<m;i++){
            if (b[i]==1){
                sumb[i]=sumb[i-1]+1;
            }
        }
        int aa[]=new int[n+2];
        int bb[]=new int[m+2];
        for (int i=0;i<n;i++){
            if (suma[i]==0)continue;
            aa[suma[i]+1]--;
            aa[1]++;
        }
        for (int i=0;i<m;i++){
            if (sumb[i]==0)continue;
            bb[sumb[i]+1]--;
            bb[1]++;
        }
        for (int i=1;i<=n;i++){
            aa[i]+=aa[i-1];
        }
        for (int i=1;i<=m;i++){
            bb[i]+=bb[i-1];
        }
        long ans=0;
        for (int i=1;i<=n;i++){
            if (k%i==0 && k/i<=m){
                ans+=aa[i]*bb[k/i];
            }
        }
        System.out.println(ans);
    }
}
