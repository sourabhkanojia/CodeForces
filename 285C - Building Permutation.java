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
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int temp;
        long count=0;
        for(int i=0;i<n;i++){
            count=count+Math.abs((i+1)-arr[i]);
        }
        System.out.println(count);
    }
}
