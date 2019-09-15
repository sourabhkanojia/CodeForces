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
        String s1=br.readLine();
        String s2=br.readLine();
 
        int pos1=0,pos2=0,neg1=0,neg2=0;
        int miss=0;
 
        int t= s1.length();
        for(int i=0;i<t;i++){
            if(s1.charAt(i)=='+')pos1++;
            else neg1++;
 
            if(s2.charAt(i)=='+')pos2++;
            else if(s2.charAt(i)=='-')neg2++;
            else miss++;
        }
 
 
        if(miss==0){
//            if(pos1==0){
//                if(pos2!=0) {
//                    System.out.printf("%.9f", 0f);
//                }
//                else System.out.printf("%.9f",1f);
//            }
//            else if(neg1==0) {
//                if (neg2 != 0) {
//                    System.out.printf("%.9f", 0f);
//                }
//                else System.out.printf("%.9f",1f);
//            }
//            else System.out.printf("%.9f",1f);
            if(pos1!=pos2)System.out.printf("%.9f", 0f);
            else System.out.printf("%.9f",1f);
        }
        else{
            if(pos1==0){
                if(pos2!=0)System.out.printf("%.9f",0f);
                else System.out.printf("%.9f",1f/Math.pow(2,miss));
            }
            else if(neg1==0){
                if(neg2!=0)System.out.printf("%.9f",0f);
                else System.out.printf("%.9f",1f/Math.pow(2,miss));
            }
            else if(pos2<=pos1 && neg2<=neg1){
                int x=pos1-pos2;
                int y=neg1-neg2;
                int base=factorial(x+y);
                x=factorial(x);
                y=factorial(y);
                int z=base/(x*y);
                System.out.printf("%.9f",z/Math.pow(2,miss));
            }
            else System.out.printf("%.9f",0f);
        }
    }
    public static int factorial(int n){
        if(n==0 || n==1)return 1;
        else if(n==2)return 2;
        else if(n==3)return 6;
        else if(n==4)return 24;
        else if(n==5)return 120;
        else if(n==6)return 720;
        else return n*factorial(n-1);
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
 
