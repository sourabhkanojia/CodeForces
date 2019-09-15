import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class problems {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int[] x = new int[n];
        int[] h = new int[n];
 
        for (int i = 0; i <n; i++) {
            x[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }
 
        int count = 0;
 
        for (int i = 0; i < n; i++) {
            if(i==0){
                dp[i]=x[i];
                count++;
            }
            else if (x[i] - h[i] > dp[i - 1]) {
                dp[i] = x[i];
                count++;
            } else if (i<n-1 && x[i] + h[i] < x[i + 1]) {
                dp[i] = x[i] + h[i];
                count++;
            }
            else if(i==(n-1)){
                dp[i]=x[i];
                count++;
            }
            else {
                dp[i] = x[i];
            }
        }
        System.out.println(count);
    }
 }
