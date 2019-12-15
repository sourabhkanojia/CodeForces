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
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();
        long max=0;
        int w,h;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            w=sc.nextInt();
            h=sc.nextInt();
            max=Math.max(arr[w-1],max);
            sb.append(max+"\n");
            max+=h;
        }
        System.out.println(sb);
    }
}
