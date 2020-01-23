import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String agr[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Point p[]=new Point[n];
        boolean vis[]=new boolean[n];
        for (int i=0;i<n;i++){
            p[i]=new Point(sc.nextInt(),sc.nextInt());
        }
        int cnt=0;
        for (int i=0;i<n;i++){
            if (!vis[i]){
                cnt++;
                dfs(p,i,vis);
            }
        }
        System.out.println(cnt-1);
    }
    static void dfs(Point p[],int v,boolean vis[]){
        if (vis[v])return;
        vis[v]=true;
        for (int i=0;i<p.length;i++){
            if (p[i].x==p[v].x || p[i].y==p[v].y){
                dfs(p,i,vis);
            }
        }
    }
}
