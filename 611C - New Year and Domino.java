import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {                                                           //Use Prefix 2-D sum.
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt(),w=sc.nextInt();
        String[] s=new String[h];
        for(int i=0;i<h;i++)s[i]=sc.nextLine();
        int[][] dp=new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++) {
                if (s[i].charAt(j) == '.') {
                    if (i - 1 >= 0 && s[i-1].charAt(j)=='.') dp[i][j]++;
                    if (j - 1 >= 0 && s[i].charAt(j-1)=='.')dp[i][j]++;
                }
            }
        }
        for(int i=0;i<h;i++){
            for(int j=1;j<w;j++)dp[i][j]+=dp[i][j-1];
        }
        for(int j=0;j<w;j++){
            for(int i=1;i<h;i++)dp[i][j]+=dp[i-1][j];
        }
        StringBuilder sb=new StringBuilder();
        int q=sc.nextInt();
        while(q-->0){
            int r1=sc.nextInt()-1,c1=sc.nextInt()-1,r2=sc.nextInt()-1,c2=sc.nextInt()-1;
            if(r1==0 && c1==0) sb.append(dp[r2][c2]+"\n");
            else if(r1==0){
                int ans=dp[r2][c2]-dp[r2][c1-1];
                for(int i=0;i<=r2;i++){
                    if(s[i].charAt(c1)=='.' && s[i].charAt(c1-1)=='.')ans--;
                }
                sb.append(ans+"\n");
            }
            else if(c1==0){
                int ans=dp[r2][c2]-dp[r1-1][c2];
                for(int j=0;j<=c2;j++){
                    if(s[r1].charAt(j)=='.' && s[r1-1].charAt(j)=='.')ans--;
                }
                sb.append(ans+"\n");
            }
            else{
                int ans=dp[r2][c2]-dp[r1-1][c2]-dp[r2][c1-1]+dp[r1-1][c1-1];
                for(int i=r1;i<=r2;i++){
                    if(s[i].charAt(c1)=='.' && s[i].charAt(c1-1)=='.')ans--;
                }
                for(int j=c1;j<=c2;j++){
                    if(s[r1].charAt(j)=='.' && s[r1-1].charAt(j)=='.')ans--;
                }
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb);
    }
}
