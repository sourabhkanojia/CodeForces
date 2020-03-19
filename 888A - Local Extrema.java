import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int ans=0;
        for(int i=1;i<n-1;i++){
            if(arr[i]<arr[i+1] && arr[i]<arr[i-1])ans++;
            else if(arr[i]>arr[i+1] && arr[i]>arr[i-1])ans++;
        }
        System.out.println(ans);
    }
}
