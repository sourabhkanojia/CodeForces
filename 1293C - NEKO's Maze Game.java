import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),q=sc.nextInt();
        boolean[][] arr=new boolean[3][n+2];
        StringBuilder sb=new StringBuilder();
        int count=0;
        while(q-->0){
            int r=sc.nextInt(),c=sc.nextInt();
            if(r==1){
                int sum=0;
                if(arr[r+1][c])sum++;
                if(arr[r+1][c-1])sum++;
                if(arr[r+1][c+1])sum++;
 
                if(arr[r][c]){
                    arr[r][c]=false;
                    count=count-sum;
                }
                else {
                    arr[r][c]=true;
                    count=count+sum;
                }
            }
            else if(r==2){
                int sum=0;
                if(arr[r-1][c])sum++;
                if(arr[r-1][c-1])sum++;
                if(arr[r-1][c+1])sum++;
 
                if(arr[r][c]){
                    arr[r][c]=false;
                    count=count-sum;
                }
                else {
                    arr[r][c]=true;
                    count=count+sum;
                }
            }
            if(count==0)sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
