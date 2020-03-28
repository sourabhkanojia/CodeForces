import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int[] a,count;
    static long ans;
    static Query[] q;
    static long[] qans;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),t=sc.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        count=new int[(int)1e6+1];
        ans=0;
        q=new Query[t];
        Query.sqrt=(int)Math.sqrt(n);
        for(int i=0;i<t;i++){
            q[i]=new Query(sc.nextInt()-1,sc.nextInt()-1,i);
        }
        Arrays.sort(q);
        qans=new long[t];
        int left=0,right=-1;
        for(int i=0;i<t;i++){
            while (left < q[i].l)  remove(a[left++]);
            while (left > q[i].l)  add(a[--left]);
            while (right < q[i].r) add(a[++right]);
            while (right > q[i].r) remove(a[right--]);
            qans[q[i].id] = ans;
        }
        for(long i : qans)sb.append(i+" ");
        System.out.println(sb);
    }

    public static void add(int val){
        ans += val * (count[val] + count[val] + 1);
        count[val]++;
    }

    public static void remove(int val){
        ans -= val * (count[val] + count[val] - 1);
        count[val]--;
    }

    public static int ip(String s){
        return Integer.parseInt(s);
    }
}

class Query implements Comparable<Query>{
    int l,r,block,id;
    static int sqrt;

    public Query(int l,int r,int id){
        this.l = l;
        this.r = r;
        block = l / sqrt ;
        this.id = id;
    }

    public int compareTo(Query b){
        if(block != b.block)
            return block - b.block;
        return r - b.r;
    }
}
