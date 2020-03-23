import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String a=sc.next(),b=sc.next();
        int[] p=new int[a.length()];
        for(int i=0;i<p.length;i++)p[i]=sc.nextInt()-1;
        int l=0,r=p.length-1,ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            char[] c=a.toCharArray();
            for(int i=0;i<=mid;i++){
                c[p[i]]='.';
            }
            boolean z=false;
            int i=0,j=0;
            while(i<a.length() && j<b.length()){
                if(c[i]==b.charAt(j)){
                    i++;
                    j++;
                }
                else i++;
                if(j==b.length()){
                    z=true;
                    break;
                }
            }
            if(z){
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        System.out.println(ans+1);
    }
}
