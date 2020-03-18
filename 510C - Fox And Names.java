import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static boolean[] vis,instack;
    static Stack<Integer> topo;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++)str[i]=sc.next();
        adj=new LinkedList[26];
        vis=new boolean[26];
        instack=new boolean[26];
        topo=new Stack<>();
        for(int i=0;i<26;i++)adj[i]=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                boolean z=false;
                int x=Math.min(str[i].length(),str[j].length());
                for(int k=0;k<x;k++){
                    if(str[i].charAt(k)!=str[j].charAt(k)){
                        z=true;
                        adj[str[i].charAt(k)-'a'].add(str[j].charAt(k)-'a');
                        break;
                    }
                }
                if(!z && str[i].length()!=x){
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        boolean cycle=false;
        for(int i=0;i<26;i++){
            if(!vis[i]){
                cycle=dfs(i);
                if(cycle)break;
            }
        }
        if(cycle) System.out.println("Impossible");
        else{
            vis=new boolean[26];
            while(!topo.isEmpty()){
                sb.append((char)(topo.peek()+'a'));
                vis[topo.pop()]=true;
            }
            for(int i=0;i<26;i++){
                if(!vis[i])sb.append((char)(i+'a'));
            }
            System.out.println(sb);
        }
    }
    static boolean dfs(int v){
        if(instack[v])return true;
        if(vis[v])return false;
        vis[v]=true;
        instack[v]=true;
        for(int u:adj[v]){
            boolean cycle=dfs(u);
            if(cycle)return true;
        }
        instack[v]=false;
        topo.add(v);
        return false;
    }
}
