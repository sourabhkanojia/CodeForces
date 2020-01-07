import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        long[] prefix=new long[n];
        while(q-->0){
            int l=sc.nextInt()-1;
            int r=sc.nextInt();
            prefix[l]++;
            if(r<n)prefix[r]--;
        }
        for(int i=1;i<n;i++)prefix[i]+=prefix[i-1];
        Arrays.sort(prefix);
        long sum=0;
        for(int i=0;i<n;i++)sum+=prefix[i]*arr[i];
        System.out.println(sum);
    }
}
