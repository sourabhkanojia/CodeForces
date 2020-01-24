import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Point[] p=new Point[n];
        for(int i=0;i<n;i++)p[i]=new Point(sc.nextInt(),sc.nextInt());
        vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,n,p);
                count++;
            }
        }
        System.out.println(count-1);
    }
    static void dfs(int i,int n,Point[] p){
        vis[i]=true;
        for(int j=0;j<n;j++){
            if(!vis[j]){
                if(p[i].x==p[j].x || p[i].y==p[j].y){
                    dfs(j,n,p);
                }
            }
        }
    }
}
