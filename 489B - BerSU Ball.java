import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class problems {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        str=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)a[i]=Integer.parseInt(str.nextToken());
 
        int m=Integer.parseInt(br.readLine());
        int[] b=new int[m];
        str=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++)b[i]=Integer.parseInt(str.nextToken());
 
        sort(a,0,a.length-1);
        sort(b,0,b.length-1);
 
        int count=0;
        int i=0;
        int j=0;
        while(i<=a.length-1 && j<=b.length-1){
            if(a[i]==b[j]){
                count++;
                i++;
                j++;
            }
            else if(a[i]<b[j]){
                if(b[j]==(a[i]+1)){
                    count++;
                    i++;
                    j++;
                }
                else i++;
            }
            else{
                if(a[i]==(b[j]+1)){
                    count++;
                    i++;
                    j++;
                }
                else j++;
            }
        }
        System.out.println(count);
 
    }
    public static void sort(int[] a,int l,int r){
        if(l<r){
            int m=l-(l-r)/2;
            sort(a,l,m);
            sort(a,m+1,r);
 
            merge(a,l,m,r);
        }
    }
    public static void merge(int[] a,int l,int m,int r){
        int[] temp=new int[r-l+1];
 
        int i=l,j=m+1,k=0;
 
        while(i<=m && j<=r){
            if(a[i]<=a[j]){
                temp[k++]=a[i];
                i++;
            }
            else{
                temp[k++]=a[j];
                j++;
            }
        }
        while(i<=m)temp[k++]=a[i++];
        while(j<=r)temp[k++]=a[j++];
 
        k=0;
        for(i=l;i<=r;i++){
            a[i]=temp[k++];
        }
    }
}
 
