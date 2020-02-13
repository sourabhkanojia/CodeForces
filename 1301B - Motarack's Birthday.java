import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
    static int mod = (int) 1e9 + 7;
    static int Infinity=Integer.MAX_VALUE;
    static int negInfinity=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            int min=Infinity,max=negInfinity;
            for(int i=0;i<n;i++){
                if(i>0 && arr[i]==-1 && arr[i-1]!=-1){
                    min=Math.min(min,arr[i-1]);
                    max=Math.max(max,arr[i-1]);
                }
                if(i+1<n && arr[i]==-1 && arr[i+1]!=-1){
                    min=Math.min(min,arr[i+1]);
                    max=Math.max(max,arr[i+1]);
                }
            }
            int set=(min+max)/2;
            for(int i=0;i<n;i++)if(arr[i]==-1)arr[i]=set;
            max=negInfinity;
            for(int i=0;i<n-1;i++){
                max=Math.max(max,Math.abs(arr[i]-arr[i+1]));
 
            }
            sb.append(max+" "+set+"\n");
        }
        System.out.println(sb);
    }
}
