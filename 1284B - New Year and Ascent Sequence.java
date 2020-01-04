import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++){
            int l=sc.nextInt();
            arr[i]=new ArrayList<>(l);
            for(int j=1;j<=l;j++)arr[i].add(sc.nextInt());
        }
        ArrayList<Integer> ll=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            boolean z=true;
            for(int j=0;j<arr[i].size()-1;j++){
                if(arr[i].get(j)<arr[i].get(j+1)) {
                    z = false;
                    break;
                }
            }
            if(z)ll.add(i);
        }
        Node[] node=new Node[ll.size()];
        for(int i=0;i<node.length;i++){
            int index=ll.get(i);
            int a=arr[index].get(0);
            int b=arr[index].get(arr[index].size()-1);
            node[i]=new Node(b,a);
        }
        Arrays.sort(node);
        long count=0;
        for(int i=0;i<node.length;i++){
            int temp=node[i].last;
            int l=0,r=node.length-1;
            int ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(node[mid].first<=temp){
                    ans=mid;
                    l=mid+1;
                }
                else r=mid-1;
            }
            count=count+(ans+1);
        }
        System.out.println((long)n*n-count);
    }
}
class Node implements Comparable<Node>{
    int first,last;
    public Node(int last,int first){
        this.last=last;
        this.first=first;
    }
    public int compareTo(Node o){
        return this.first-o.first;
    }
}
