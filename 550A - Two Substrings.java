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
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        String s=br.readLine();
        boolean x=false,y=false,z=false;
        s=s+"x";
        int t=s.length()-1;
        for(int i=0;i<t;i++){
            if(s.charAt(i)=='A') {
                if (s.charAt(i + 1) == 'B') {
                    if (s.charAt(i + 2) == 'A' && !z) {
                        z = true;
                        i++;
                        i++;
                    } else {
                        x = true;
                        i++;
                    }
                }
            }
            else if(s.charAt(i)=='B') {
                if (s.charAt(i + 1) == 'A') {
                    if (s.charAt(i + 2) == 'B' && !z) {
                        z = true;
                        i++;
                        i++;
                    } else {
                        y = true;
                        i++;
                    }
                }
            }
 
            if((z && x)||(z && y)||(x && y)) break;
        }
        if((z && x)||(z && y)||(x && y)) System.out.println("YES");
        else System.out.println("NO");
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
 
 
