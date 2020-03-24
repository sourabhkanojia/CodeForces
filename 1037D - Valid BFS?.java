import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        LinkedList<Integer>[] adj=new LinkedList[n];
        for(int i=0;i<n;i++)adj[i]=new LinkedList<>();
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] order=new int[n];
        for(int i=0;i<n;i++)order[sc.nextInt()-1]=i;
        for(int i=0;i<n;i++){
            Collections.sort(adj[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return order[o1]-order[o2];
                }
            });
        }
        int[] ans=new int[n];
        int count=0;
        LinkedList<Integer> queue=new LinkedList<>();
        boolean[] vis=new boolean[n];
        queue.add(0);
        vis[0]=true;
        while(!queue.isEmpty()){
            int i=queue.removeFirst();
            ans[i]=count++;
            for(int node:adj[i]){
                if(!vis[node]){
                    vis[node]=true;
                    queue.add(node);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ans[i]!=order[i]){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
