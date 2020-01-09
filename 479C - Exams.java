import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node[] node=new Node[n];
        for(int i=0;i<n;i++)node[i]=new Node(sc.nextInt(),sc.nextInt());
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.a==o2.a)return o1.b-o2.b;
                else return o1.a-o2.a;
            }
        });
        int min=-1;
        for(int i=0;i<n;i++){
            int temp=Math.min(node[i].a,node[i].b);
            if(temp>=min)min=temp;
            else min=Math.max(node[i].a,node[i].b);
        }
        System.out.println(min);
    }
}
