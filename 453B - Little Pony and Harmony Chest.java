import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+9;
    static int val[];
    static int ps[]={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59};
    static int n;
    static int a[];
    static int dp[][];
    static int res[][];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        val=new int[61];
        for(int i=1;i<=60;i++){
            for(int j=0;j<16;j++){
                if(i%ps[j]==0){
                    val[i]|=(1<<j);
                }
            }
        }
        n=sc.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        dp=new int[n][1<<16];
        res=new int[n][1<<16];
        for(int[] i:dp)Arrays.fill(i,-1);
        sol(0,0);
        int temp=0;
        for(int i=0;i<n;i++){
            sb.append(res[i][temp]+" ");
            temp|=val[res[i][temp]];
        }
        System.out.println(sb);
    }
    static int sol(int c,int m){
        if(c>=n)return 0;
        if(dp[c][m]!=-1)return dp[c][m];
        int ans=(int)1e9;
        for(int i=1;i<=60;i++){
            if((val[i]&m)==0){
                int dist=Math.abs(a[c]-i)+sol(c+1,m|val[i]);
                if(dist<ans){
                    ans=dist;
                    res[c][m]=i;
                }
            }
        }
        return dp[c][m]=ans;
    }
}
