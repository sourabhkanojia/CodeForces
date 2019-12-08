import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[m];
        for(int i=0;i<m;i++)a[i]=sc.nextInt();
        Arrays.sort(a);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=m-n;i++){
            if(a[i+n-1]-a[i]<min){
                min=a[i+n-1]-a[i];
            }
        }
        System.out.println(min);
    }
}
