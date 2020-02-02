import javax.print.attribute.standard.PrintQuality;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node[] node=new Node[n];
        for(int i=0;i<n;i++)node[i]=new Node(sc.nextInt(),sc.nextInt());
        Arrays.sort(node);
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            long x=node[i].x,y=node[i].y;
            if(x>0)sb.append("1 "+x+" R\n");
            else if(x<0) sb.append("1 "+Math.abs(x)+" L\n");

            if(y>0)sb.append("1 "+y+" U\n");
            else if(y<0) sb.append("1 "+Math.abs(y)+" D\n");

            sb.append("2\n");

            if(x>0)sb.append("1 "+x+" L\n");
            else if(x<0)sb.append("1 "+Math.abs(x)+" R\n");

            if(y>0)sb.append("1 "+y+" D\n");
            else if(y<0) sb.append("1 "+Math.abs(y)+" U\n");

            sb.append("3\n");
            if(x!=0)count+=2;
            if(y!=0)count+=2;
            count+=2;
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
class Node implements Comparable<Node>{
    int x,y,dist;
    Node(int x,int y){
        this.x=x;this.y=y;
        dist=Math.abs(x)+Math.abs(y);
    }
    public int compareTo(Node o){
        return this.dist-o.dist;
    }
}
