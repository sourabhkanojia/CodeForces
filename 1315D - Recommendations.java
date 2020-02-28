import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node[] node=new Node[n];
        for(int i=0;i<n;i++){
            node[i]=new Node();
            node[i].a=sc.nextInt();
        }
        for(int i=0;i<n;i++)node[i].t=sc.nextInt();
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a-o2.a;
            }
        });
        PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.t-o1.t;
            }
        });
        long curr=node[0].a;
        long ans=0;
        for(int i=0;i<n;i++){
            if(curr==node[i].a){
                pq.add(node[i]);
                continue;
            }
            while(!pq.isEmpty() && curr<node[i].a){
                Node e=pq.poll();
                ans+=(curr-e.a)*e.t;
                curr++;
            }
            curr=node[i].a;
            pq.add(node[i]);
        }

        while(!pq.isEmpty()){
            Node e=pq.poll();
            ans+=(curr-e.a)*e.t;
            curr++;
        }
        System.out.println(ans);
    }
}
class Node{
    int a, t;
}
