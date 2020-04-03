import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),I=8*sc.nextInt();
        int[] arr=new int[n];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int k=I/n;
        int K=(int)Math.pow(2,k);
        if(hm.size()<=K) System.out.println(0);
        else{
            Node[] node=new Node[hm.size()];
            int i=0;
            for(int j:hm.keySet()){
                node[i++]=new Node(j,hm.get(j));
            }
            Arrays.sort(node, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.val-o2.val;
                }
            });
            for(i=1;i<node.length;i++)node[i].count+=node[i-1].count;
            int l=0,r=K-1,size=node.length;
            int min=node[size-1].count-node[r].count;
            l++;r++;
            while(r<node.length){
                min=Math.min(min,(node[size-1].count-node[r].count)+node[l-1].count);
                l++;r++;
            }
            System.out.println(min);
        }
    }
}
class Node{
    int val,count;
    public Node(int val,int count){
        this.val=val;
        this.count=count;
    }
}
