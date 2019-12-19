import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=sorted[i])count++;
            if(count>2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
