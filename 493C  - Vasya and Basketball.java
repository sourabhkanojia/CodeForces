import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();

        int m=sc.nextInt();
        int[] b=new int[m];
        for(int i=0;i<m;i++)b[i]=sc.nextInt();
        Node[] node=new Node[n+m];

        int j=0;
        for(int i=0;i<n;i++)node[j++]=new Node(a[i],1);
        for(int i=0;i<m;i++)node[j++]=new Node(b[i],2);

        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist-o2.dist;
            }
        });
        a=new int[n+m];
        b=new int[n+m];
        for(int i=0;i<n+m;i++){
            if(node[i].team==1)a[i]=1;
            else b[i]=1;

            if(i>0){
                a[i]+=a[i-1];
                b[i]+=b[i-1];
            }
        }
        int ma=a[n+m-1]*3,mb=b[n+m-1]*3;
        for(int i=0;i<n+m;i++){
            int one=a[i]*2+(a[node.length-1]-a[i])*3;
            int two=b[i]*2+(b[node.length-1]-b[i])*3;
            if(one-two>ma-mb){
                ma=one;
                mb=two;
            }
        }
        System.out.println(ma+":"+mb);
    }
}
class Node{
    int dist,team;
    public Node(int dist,int team){
        this.dist=dist;
        this.team=team;
    }
}
