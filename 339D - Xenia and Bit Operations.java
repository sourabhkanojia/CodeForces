import java.util.*;
import java.io.*;
 
public class Main{
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[(int)Math.pow(2,n)];
        for(int i=0;i<arr.length;i++)arr[i]=sc.nextInt();
        int[] tree=new int[4*arr.length+1];
        boolean z;
        if(n%2==0)z=false;
        else z=true;
        StringBuilder sb=new StringBuilder();
        buildTree(tree,arr,1,0,arr.length-1,z);
        while(m-->0){
            int p=sc.nextInt()-1;
            int b=sc.nextInt();
            int temp=arr[p];
            update(tree,1,0,arr.length-1,p,b,z);
            sb.append(tree[1]+"\n");
        }
        System.out.println(sb);
    }
    //Build Tree
    public static void buildTree(int[] tree,int[] a,int index,int s,int e,boolean z){
        if(s>e)return;
        if(s==e){
            tree[index]=a[s];
            return;
        }
        int mid=s+(e-s)/2;
        //left subtree
        if(z)buildTree(tree,a,2*index,s,mid,false);
        else buildTree(tree,a,2*index,s,mid,true);
        //right subtree
        if(z) buildTree(tree,a,2*index+1,mid+1,e,false);
        else buildTree(tree,a,2*index+1,mid+1,e,true);
 
        int left=tree[2*index];
        int right=tree[2*index+1];
        if(z)tree[index]=left|right;
        else tree[index]=left^right;
    }
    //Query
    public static int query(int[] tree,int index,int s,int e,int qs,int qe){
        //3 Cases
        //No overlap
        if(qs>e || qe<s)return Integer.MAX_VALUE;
        //Complete Overlap
        if(s>=qs && e<=qe)return tree[index];
        //Partial Overlap -> Call both sides
        int mid=s+(e-s)/2;
        int left=query(tree,2*index,s,mid,qs,qe);
        int right=query(tree,2*index+1,mid+1,e,qs,qe);
        return Integer.min(left,right);
    }
    //Update
    public static void update(int[] tree,int index,int s,int e,int i,int value,boolean z){
        //No overlap
        if(i<s || i>e)return;
        //Reached leaf node
        if(s==e){
            tree[index]=value;
            return;
        }
        //Partial Overlap
        int mid=s+(e-s)/2;
        if(i>=s && i<=mid){
            if(z)update(tree,2*index,s,mid,i,value,false);
            else update(tree,2*index,s,mid,i,value,true);
        }
        else {
            if(z)update(tree,2*index+1,mid+1,e,i,value,false);
            else update(tree,2*index+1,mid+1,e,i,value,true);
        }
        if(z)tree[index]=tree[2*index]|tree[2*index+1];
        else tree[index]=tree[2*index]^tree[2*index+1];
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(next());
    }
 
    long nextLong() {
        return Long.parseLong(next());
    }
 
    double nextDouble() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
