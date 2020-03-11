import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Main {                                                    // Answer is reverse sort.
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);  
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            for(int j=n;j>0;j--){
                int max=Integer.MIN_VALUE;
                int index=-1;
                for(int i=0;i<j;i++){
                    if(j-arr[i]>max){
                        index=i;
                        max=j-arr[i];
                    }
                }
                int temp=arr[j-1];
                arr[j-1]=arr[index];
                arr[index]=temp;
            }
            for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}
