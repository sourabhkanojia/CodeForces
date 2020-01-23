import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Point[] p=new Point[n];
        for(int i=0;i<n;i++){
            p[i]=new Point(sc.nextInt(),sc.nextInt());
        }
        disJoint set=new disJoint(n);
        LinkedList<Point> ll;
        LinkedList<Integer> index;
        for(int i=0;i<n;i++){
            ll=new LinkedList<>();
            index=new LinkedList<>();
            for(int j=0;j<n;j++){
                if(p[i].x==p[j].x || p[i].y==p[j].y){
                    set.union(i,j);
                    ll.addLast(p[j]);
                    index.addLast(j);
                }
            }
            while(!ll.isEmpty()){
                Point point=ll.removeFirst();
                int k=index.removeFirst();
                for(int j=0;j<n;j++){
                    if(k==j)continue;
                    if(point.x==p[j].x || point.y==p[j].y){
                        int a=set.find(k);
                        int b=set.find(j);
                        if(a!=b){
                            ll.addLast(p[j]);
                            index.addLast(j);
                            set.union(a,b);
                        }
                    }
                }
            }
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)hs.add(set.parent[i]);
        System.out.println(hs.size()-1);
    }
}
class disJoint{
    int[] parent;
    int[] size;
    public disJoint(int n){
        parent=new int[n];
        size=new int[n];
        makeSet();
    }
    public void makeSet(){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int v){
        if(parent[v]==v)return v;
        else return parent[v]=find(parent[v]);
    }
    public void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]<size[b])parent[a]=b;
            else parent[b]=a;
        }
    }
}
