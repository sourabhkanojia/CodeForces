import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileInputStream;
 
public class CandidateCode {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]==1)count++;
        }
        for(int i=0;i<n;i++){
            if(a[i]==1)a[i]=-1;
            else a[i]=1;
        }
        count=count+kadane(a);
        System.out.println(count);
    }
    public static int kadane(int[] a){
        int max_current=a[0];
        int max_global=a[0];
        for(int i=1;i<a.length;i++){
            max_current=Integer.max(a[i],max_current+a[i]);
            if(max_current>max_global){
                max_global=max_current;
            }
        }
        return max_global;
    }
}
 
