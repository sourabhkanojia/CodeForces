import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    static int count=0;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        char[][] arr=new char[n][m];
        for(int i=0;i<n;i++){
            arr[i]=sc.next().toCharArray();
        }
        boolean[][] vis;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='.'){
                    vis=new boolean[n][m];
                    vis[i][j]=true;
                    dfs(arr,i,j,n,m,k,vis);
                }
                if(count==k){
                    for(int y=0;y<n;y++){
                        System.out.println(arr[y]);
                    }
                    return;
                }
            }
        }

    }
    public static void dfs(char[][] arr,int i,int j,int n,int m,int k,boolean[][] vis){
        if(count>k)return;
        if(j+1<m && arr[i][j+1]=='.' && count<=k && !vis[i][j+1]){
            vis[i][j+1]=true;
            dfs(arr,i,j+1,n,m,k,vis);
        }
        if(j-1>=0 && arr[i][j-1]=='.' && count<=k && !vis[i][j-1]){
            vis[i][j-1]=true;
            dfs(arr,i,j-1,n,m,k,vis);
        }
        if(i+1<n && arr[i+1][j]=='.' && count<=k && !vis[i+1][j]){
            vis[i+1][j]=true;
            dfs(arr,i+1,j,n,m,k,vis);
        }
        if(i-1>=0 && arr[i-1][j]=='.' && count<=k && !vis[i-1][j]) {
            vis[i - 1][j] = true;
            dfs(arr, i - 1, j, n, m, k, vis);
        }
        if(count<k){
            arr[i][j]='X';
            count++;
        }
    }
}
