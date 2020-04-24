import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),k=sc.nextInt();
            int[] arr=new int[n+1];
            for(int i=1;i<=n;i++)arr[i]=sc.nextInt();
            boolean[] peak=new boolean[n+1];
            for(int i=2;i<n;i++){
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1])peak[i]=true;
            }
            int count=0;
            for(int i=2;i<k;i++){
                if(peak[i])count++;
            }
            int max=count;
            int l=1;
            int L=2,R=k+1;
            while(R<=n){
                if(peak[L])count--;
                if(peak[R-1])count++;
                if(count>max){
                    max=count;
                    l=L;
                }
                R++;
                L++;
            }
            sb.append((max+1)+" "+l+"\n");
        }
        System.out.println(sb);
    }
}
