import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node[] node=new Node[10];
        node[0]=new Node(0,0);
        for(int i=1;i<10;i++)node[i]=new Node(i,sc.nextInt());
        int temp=-1,min=Integer.MAX_VALUE;
        for(int i=1;i<10;i++){
            if(min>node[i].value){
                min=node[i].value;
                temp=node[i].i;
            }
            else if(min==node[i].value)temp=node[i].i;
        }
        int sol=n/min;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=sol;i++)sb.append(""+temp);
        sol=n%min;
        for(int i=0;i<sb.length();i++){
            sol=sol+min;

            int z=-1;
            for(int j=temp+1;j<10;j++){
                if(sol>=node[j].value)z=j;
            }
            if(z==-1)break;
            else{
                sb.replace(i,i+1,""+node[z].i);
                sol=sol-node[z].value;
            }
        }
        if(sb.length()==0) System.out.println(-1);
        else System.out.println(sb);
    }
}
