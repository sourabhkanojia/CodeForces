import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        makeSet(n);
        int[] p=new int[n];
        int[] ind=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt()-1;
            ind[p[i]]=i;
        }
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<n;j++){
                if(s.charAt(j)=='1'){
                    int a=findParent(i),b=findParent(j);
                    if(a!=b)union(a,b);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<p[i];j++){
                if(i<=ind[j] && findParent(i)==findParent(ind[j])){
                    int temp=p[i];
                    p[i]=j;
                    p[ind[j]]=temp;
                    ind[temp]=ind[p[i]];
                    ind[j]=i;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            sb.append(p[i]+1+" ");
        }
        System.out.println(sb);
    }
    static int[] parent,size;
    static void makeSet(int v){
        parent=new int[v];
        size=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    static int findParent(int v){
        if(v==parent[v])return v;
        else return parent[v]=findParent(parent[v]);
    }
    static void union(int a,int b){
        if(size[a]<size[b]){
            parent[a]=b;
            size[b]+=size[a];
        }
        else{
            parent[b]=a;
            size[a]+=size[b];
        }
    }
}
