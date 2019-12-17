import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Point[] arr=new Point[n];
        disjointSet set=new disjointSet(n);
        set.makeSet();
        for(int i=0;i<n;i++){
            arr[i]=new Point(sc.nextInt(),sc.nextInt());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x=set.find(i);
                int y=set.find(j);
                if(x!=y){
                    if(arr[i].x==arr[j].x || arr[i].y==arr[j].y){
                        set.union(x,y);
                    }
                }
            }
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)hs.add(set.find(i));
        System.out.println(hs.size()-1);
    }
}
class disjointSet{
    int[] parent;
    public disjointSet(int v){this.parent=new int[v];}
    public void makeSet(){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }
    public int find(int v){
        if (v == parent[v]) return v;
        return parent[v]=find(parent[v]);
    }
    public void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            parent[b]=a;
        }
    }
}
