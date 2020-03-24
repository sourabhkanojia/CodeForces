import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in):
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int mid=n/2;
        int l=0,r=mid;
        while(l<mid && r<n){
            if(arr[l]*2<=arr[r]){
                l++;
                r++;
            }
            else r++;
        }
        System.out.println(mid+(mid-l)+((n&1)==1?1:0));
    }
}
