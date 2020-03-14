import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n=sc.nextInt();
        int[] a=new int[n],b=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i=0;i<n;i++)b[i]=sc.nextInt();
        Integer[] c=new Integer[n];
        for(int i=0;i<n;i++){
            c[i]=a[i]-b[i];
        }
        Arrays.sort(c);
        long sum=0;
        for(int i=0;i<n;i++){
            if(c[i]>0){
                sum+=(n-(i+1));
            }
            else{
                int l=i+1,r=n-1,ans=-1;
                while(l<=r){
                    int mid=l+(r-l)/2;
                    if(c[mid]+c[i]>0){
                        ans=mid;
                        r=mid-1;
                    }
                    else l=mid+1;
                }
                if(ans!=-1)sum+=(n-ans);
            }
        }
        System.out.println(sum);
    }
}
