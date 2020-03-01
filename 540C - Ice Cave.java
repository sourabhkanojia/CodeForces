import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static char[][] c;
    static int r1,r2,c1,c2,n,m;
    static boolean z=false;
    static boolean[][] vis;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in):
        StringBuilder sb=new StringBuilder();
        n=sc.nextInt();m=sc.nextInt();
        c=new char[n][m];
        vis=new boolean[n][m];
        for(int i=0;i<n;i++)c[i]=sc.next().toCharArray();
        r1=sc.nextInt()-1;c1=sc.nextInt()-1;r2=sc.nextInt()-1;c2=sc.nextInt()-1;
        if(c[r2][c2]=='X'){
            if(r2+1<n )dfs(r2+1,c2);
            if(c2+1<m )dfs(r2,c2+1);;
            if(r2-1>=0)dfs(r2-1,c2);
            if(c2-1>=0)dfs(r2,c2-1);
        }
        else{
            int count=0;
            if(r2+1<n && c[r2+1][c2]=='.')count++;
            if(c2+1<m && c[r2][c2+1]=='.')count++;
            if(r2-1>=0 && c[r2-1][c2]=='.')count++;
            if(c2-1>=0 && c[r2][c2-1]=='.')count++;
            if(count>=2){
                if(r2+1<n)dfs(r2+1,c2);
                if(c2+1<m)dfs(r2,c2+1);;
                if(r2-1>=0)dfs(r2-1,c2);
                if(c2-1>=0)dfs(r2,c2-1);
            }
            else if(count==1){
                if(r2==r1){
                    if(c2+1==c1)z=true;
                    else if(c2-1==c1)z=true;
                }
                else if(c2==c1){
                    if(r2+1==r1)z=true;
                    else if(r2-1==r1)z=true;
                }
            }
        }
        System.out.println(z?"YES":"NO");
    }
    static void dfs(int i,int j){
        if(!vis[i][j]) {
            vis[i][j]=true;
            if (c[i][j] == 'X') {
                if (i == r1 && j == c1) {
                    z = true;
                    return;
                } else return;
            }
            c[i][j] = 'X';
            if (i + 1 < n) dfs(i + 1, j);
            if (j + 1 < m) dfs(i, j + 1);
            if (i - 1 >= 0) dfs(i - 1, j);
            if (j - 1 >= 0) dfs(i, j - 1);
            c[i][j] = '.';
        }
    }
}
