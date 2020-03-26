import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static int[] col;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)adj[i]=new LinkedList<>();
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        col=new int[n];
        for(int i=0;i<n;i++)col[i]=sc.nextInt();
        boolean z=false;
        int u=-1,v=-1;
        for(int i=0;i<n;i++){
            for(int j:adj[i]){
                if(col[i]!=col[j]){
                    z=true;
                    u=i;v=j;
                    break;
                }
            }
        }
        if(!z){
            System.out.println("YES");
            System.out.println(1);
        }
        else {
            z=true;
            for(int i:adj[u]){
                if(!dfs(i,u)){
                    z=false;
                    break;
                }
            }
            if(z){
                System.out.println("YES");
                System.out.println(u+1);
                return;
            }
            for(int i:adj[v]){
                if(!dfs(i,v)){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
            System.out.println(v+1);
        }
    }
    static boolean dfs(int v,int par){
        for(int u:adj[v]){
            if(u!=par){
                if(col[u]!=col[v])return false;
                if(!dfs(u,v))return false;
            }
        }
        return true;
    }
}
