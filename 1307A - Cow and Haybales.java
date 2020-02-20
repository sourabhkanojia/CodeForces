import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),d=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            while (d-->0){
                for (int i=1;i<n;i++)
                    if (arr[i]>0){
                        arr[i]--;
                        arr[i-1]++;
                        break;
                    }
            }
            System.out.println(arr[0]);
        }
    }
}
