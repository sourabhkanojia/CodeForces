import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        long[] d1=new long[2*n+1],d2=new long[2*n+1],res=new long[2];
        int x[] = new int[2], y[] = new int[2];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j]=sc.nextInt();
                d1[i+j]+=arr[i][j];
                d2[i-j+n]+=arr[i][j];
            }
        }
        res[0]=res[1]=-1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int pos=(i+j)&1;
                long sum=d1[i+j]+d2[i-j+n]-arr[i][j];
                if(sum>res[pos]){
                    res[pos]=sum;
                    x[pos]=i;
                    y[pos]=j;
                }
            }
        }
        System.out.println(res[0]+res[1]);
        System.out.println(x[0]+" "+y[0]+" "+x[1]+" "+y[1]);
    }
}
