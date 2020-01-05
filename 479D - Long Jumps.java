import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(Sytem.in);
        int n = sc.nextInt(), l = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int p = -1, q = -1;
        p = binarySearch(arr, x);
        q = binarySearch(arr, y);
        if (p != -1 && q != -1) System.out.println(0);
        else if (p != -1) {
            System.out.println(1);
            System.out.println(arr[0] + y);
        } else if (q != -1) {
            System.out.println(1);
            System.out.println(arr[0] + x);
        } else {
           HashSet<Integer> hs=new HashSet<>();
           for(int i=0;i<n;i++)hs.add(arr[i]);
           for(int i=0;i<n;i++){
               int a=0,b=0,c=0,d=0;
               if(arr[i]-x>=0)a=arr[i]-x;
               if(arr[i]+x<=l)b=arr[i]+x;
               if(arr[i]-y>=0)c=arr[i]-y;
               if(arr[i]+y<=l)d=arr[i]+y;

               if(hs.contains(a-y) || hs.contains(a+y)){
                   System.out.println(1+"\n"+a);
                   return;
               }
               else if(hs.contains(b-y) || hs.contains(b+y)){
                   System.out.println(1+"\n"+b);
                   return;
               }
               else if(hs.contains(c-x) || hs.contains(c+x)){
                   System.out.println(1+"\n"+c);
                   return;
               }
               else if(hs.contains(d-x) || hs.contains(d+x)){
                   System.out.println(1+"\n"+d);
                   return;
               }
           }
            System.out.println(2+"\n"+(arr[0]+x)+" "+(arr[0]+y));
        }
    }
    public static int  binarySearch(int[] arr,int x) {
        for (int i = 0; i < arr.length; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int temp = arr[mid] - arr[i];
                if (temp == x) return mid;
                else if (temp > x) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}
