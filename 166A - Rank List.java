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
        int k=sc.nextInt();
        Node[] node=new Node[n];
        for(int i=0;i<n;i++)node[i]=new Node(sc.nextInt(),sc.nextInt());
        Arrays.sort(node);
        int p=node[k-1].problems;
        int t=node[k-1].time;
        int count=1;
        for(int i=k;i<n;i++){
            if(node[i].problems==p && node[i].time==t){
                count++;
            }
            else break;
        }
        for(int i=k-2;i>=0;i--){
            if(node[i].problems==p && node[i].time==t){
                count++;
            }
            else break;
        }
        System.out.println(count);
    }
}
class Node implements Comparable<Node>{
    int problems;
    int time;
    public Node(int problems,int time){
        this.problems=problems;
        this.time=time;
    }

    public int compareTo(Node o){
        if(o.problems==this.problems){
            return this.time-o.time;
        }
        else return o.problems-this.problems;
    }
}
