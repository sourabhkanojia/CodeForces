import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    static HashSet<Integer> hsg;
    static HashSet<Integer>[] hs;
    static boolean[] vis;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),q=sc.nextInt();
        long[] arr=new long[n+1];
        for(int i=1;i<=n;i++)arr[i]=sc.nextInt();

        Node[] node=new Node[m+1];
        for(int i=1;i<=m;i++){
            node[i]=new Node(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        long[] temp=new long[m+1];
        for(int i=1;i<=q;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            temp[x]++;
            if(y+1<=m)temp[y+1]--;
        }

        for(int i=1;i<=m;i++)temp[i]=temp[i]+temp[i-1];
        long[] sum=new long[n+1];
        for(int i=1;i<=m;i++){
            int x=node[i].l,y=node[i].r,d=node[i].d;
            sum[x]=sum[x]+d*temp[i];
            if(y+1<=n)sum[y+1]=sum[y+1]-d*temp[i];
        }
        for(int i=1;i<=n;i++)sum[i]+=sum[i-1];
        for(int i=1;i<=n;i++) System.out.print((arr[i]+sum[i])+" ");
    }
}
class Node{
    int l,r,d;
    Node(int l,int r,int d){
        this.l=l;
        this.r=r;
        this.d=d;
    }
}
