import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static HashSet<Integer> hsg;
    static HashSet<Integer>[] hs;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),count=0;
        hs=new HashSet[n];
        LinkedList<Integer> zero=new LinkedList<>();
        for(int i=0;i<n;i++)hs[i]=new HashSet<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            for(int j=1;j<=a;j++)hs[i].add(sc.nextInt());
            if(a==0)zero.add(i);
        }
        if(zero.size()==n){
            for(int i=0;i<n;i++)hs[i].add(1);
            count=n;
        }
        else{
            int a=0;
            for(int i=0;i<n;i++){
                if(hs[i].size()!=0){
                    for(int j:hs[i]){
                        a=j;
                        break;
                    }
                }
            }
            for(int i:zero){
                hs[i].add(a);
            }
            count=zero.size();
        }
        disJoint set=new disJoint(n);
        for(int i=0;i<n;i++){
            vis=new boolean[n];
            hsg=new HashSet<>();
            for(int j:hs[i]){
                hsg.add(j);
            }
            vis[i]=true;
            dfs(set,n,i);
        }
        HashSet<Integer> temp=new HashSet<>();
        for(int i=0;i<n;i++)temp.add(set.parent[i]);
        System.out.println(temp.size()-1+count);
    }
    static void dfs(disJoint set,int n,int parent){
        for(int i=0;i<n;i++){
            if(!vis[i]){
                boolean z=false;
                for(int j:hs[i]){
                    if(hsg.contains(j)){
                        z=true;
                        break;
                    }
                }
                if(z){
                    vis[i]=true;
                    set.union(i,parent);
                    for(int j:hs[i]){
                       hsg.add(j);
                    }
                    dfs(set,n,i);
                }
            }
        }
    }
}
class disJoint{
    int[] parent;
    int[] size;
    disJoint(int n){
        parent=new int[n];
        size=new int[n];
        makeSet();
    }
    void makeSet(){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int v){
        if(parent[v]==v)return v;
        else return parent[v]=find(parent[v]);
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]<size[b])parent[a]=b;
            else parent[b]=a;
        }
    }
}
