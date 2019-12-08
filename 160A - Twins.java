import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int x=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            x=x+arr[i];
        }
        Arrays.sort(arr);
        int min=0;
        int y=0;
        for(int i=n-1;i>=0;i--){
            if(x>=y){
                y+=arr[i];
                min++;
                x=x-arr[i];
            }
            else break;
        }
        System.out.println(min);
    }
}
