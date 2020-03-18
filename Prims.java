// Prim's algorithm - It is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph.
// To apply these algorithms, the given graph must be weighted, connected and undirected.

import java.awt.*;
import java.io.*;
import java.util.*;

public class Prims {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();                     // n is number of vertex and m is number of edges.
        LinkedList<Point>[] ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1,w=sc.nextInt();
            ll[u].add(new Point(v,w));
            ll[v].add(new Point(u,w));
        }
        boolean[] vis=new boolean[n];
        int[] parent=new int[n];
        int[] weight=new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(weight,Integer.MAX_VALUE);
        PriorityQueue<Point> pq=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y-o2.y;
            }
        });
        weight[0]=0;
        pq.add(new Point(0,0));
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(!vis[p.x]){
                vis[p.x]=true;
                for(Point node:ll[p.x]){
                    if(!vis[node.x]){
                        if(weight[node.x]>node.y){
                            weight[node.x]=node.y;
                            parent[node.x]=p.x;
                            pq.add(new Point(node.x,weight[node.x]));
                        }
                    }
                }
            }
        }
        int sumOfWeight=0;
        for(int i=0;i<n;i++){
            sumOfWeight+=weight[i];
        }
        System.out.println("Weight of minimum spanning tree - "+sumOfWeight);
    }
}
