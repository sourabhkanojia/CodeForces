import java.awt.*;
import java.awt.dnd.Autoscroll;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.util.Scanner;
 
 
public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        long temp=0;
        for(int i=0;i<k;i++)temp+=a[i];
        long[] prefix=new long[n];
 
        prefix[0]=a[0];
        for(int i=1;i<k;i++)prefix[i]=(prefix[i-1]+a[i]);
        prefix[0]=prefix[k-1];
        for(int i=1;i<=n-k;i++){
            prefix[i]=prefix[i-1]+a[i+k-1]-a[i-1];
        }
 
        long max=temp;
        int start=0;
        int[] arr1=new int[n];
        arr1[k-1]=start;
        for(int i=k;i<n;i++){
            temp=temp-a[i-k]+a[i];
            if(temp>max){
                max=temp;
                start=i-k+1;
            }
            arr1[i]=start;
        }
        int[] arr2=new int[n];
        start=n-k;
        max=temp;
        arr2[start]=start;
 
        for(int i=n-k-1;i>=0;i--){
            temp=temp-a[i+k]+a[i];
            if(temp>=max){
                max=temp;
                start=i;
            }
            arr2[i]=start;
        }
        max=0;
        int c=-1;
        int d=-1;
        for(int i=k-1;i<n-k;i++){
 
            if(max<prefix[arr1[i]]+prefix[arr2[i+1]]){
                max=prefix[arr1[i]]+prefix[arr2[i+1]];
                c=arr1[i];
                d=arr2[i+1];
            }
        }
        System.out.println((c+1)+" "+(d+1));
    }
}
class Node implements Comparable<Node>{
    int i,j,value;
    public Node(int i,int j,int value){
        this.i=i;this.j=j;this.value=value;
    }
    public int compareTo(Node o){
        if(this.value-o.value>0)return 1;
        else if(this.value-o.value<0)return -1;
        else{
            return o.i-this.i;
        }
    }
}
