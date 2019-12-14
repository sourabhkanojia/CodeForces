import java.awt.dnd.Autoscroll;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node[] node=new Node[n];
        for(int i=0;i<n;i++){
            node[i]=new Node(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(node);
        for(int i=0;i<n-1;i++){
            if(node[i].quality>node[i+1].quality){
                System.out.println("Happy Alex");
                return;
            }
        }
        System.out.println("Poor Alex");
    }
}
class Node implements Comparable<Node>{
    int price;
    int quality;
    public Node(int price,int quality){
        this.price=price;
        this.quality=quality;
    }
    public int compareTo(Node o){
        return this.price-o.price;
    }
}
