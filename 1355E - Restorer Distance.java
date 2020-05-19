import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int n,a,r,m;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        n=sc.nextInt();a=sc.nextInt();r=sc.nextInt();m=sc.nextInt();
        int[] h=new int[n];
        for(int i=0;i<n;i++)h[i]=sc.nextInt();
        long left=0,right=(long)1e9 + 1;
        long ans=Long.MAX_VALUE;
        m=Math.min(m,a+r);
        while(right-left>2){
            long m1=left+(right-left)/3;
            long m2=right-(right-left)/3;
            long temp1=cost(h,m1);
            long temp2=cost(h,m2);
            ans=Math.min(ans,Math.min(temp1,temp2));
            if(temp1>temp2)left=m1;
            else if(temp2>temp1)right=m2;
            else{left=m1;right=m2;}
        }
        for(;left<=right;left++)ans=Math.min(ans,cost(h,left));
        System.out.println(ans);
    }
    static long cost(int[] h,long mid){
        long add=0,remove=0;
        for(int i=0;i<h.length;i++){
            if(h[i]>mid)remove+=(h[i]-mid);
            else add+=(mid-h[i]);
        }
        if(add>=remove)return (add-remove)*a+remove*m;
        else return (remove-add)*r+add*m;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
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
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
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
