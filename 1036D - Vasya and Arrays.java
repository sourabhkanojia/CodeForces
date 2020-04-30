import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int m=sc.nextInt();
        int[] b=new int[m];
        for(int i=0;i<m;i++)b[i]=sc.nextInt();

        int i=0,j=0,count=0;
        long asum=a[0],bsum=b[0];
        boolean z=true;
        while(i<n && j<m){
            if(asum==bsum){
                count++;
                i++;j++;
                if(i==n && j<m){
                    z=false;
                    break;
                }
                if(j==m && i<n){
                    z=false;
                    break;
                }
                if(i==n && j==m)break;
                asum=a[i];bsum=b[j];
            }
            else if(asum<bsum){
                i++;
                if(i==n){
                    System.out.println(-1);
                    return;
                }
                asum+=a[i];
            }
            else{
                j++;
                if(j==m){
                    z=false;
                    break;
                }
                bsum+=b[j];
            }
        }
        if(z) System.out.println(count);
        else System.out.println(-1);
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
