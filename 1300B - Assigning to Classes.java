import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int arr[] = new int[2*n];
            for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
            n = n * 2;
            Arrays.sort(arr);

            System.out.println(arr[n / 2] - arr[(n / 2) - 1]);
        }
    }
}
