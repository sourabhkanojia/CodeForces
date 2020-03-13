import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int test=sc.nextInt();
        while (test-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            int min=100;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                min=Math.min(arr[i],min);
            }
            for(int i=0;i<n;i++)arr[i]-=min;
            boolean z=false;
            for(int i=0;i<n;i++){
                if(arr[i]%2!=0){
                    z=true;
                    break;
                }
            }
            if(z)sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
