import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        int[] a=new int[m];
        long sum=0;
        for(int i=0;i<m;i++){
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        if(sum<n){
            System.out.println(-1);
            return;
        }
        int[] b=new int[m];
        long temp=sum-n;
        int j=1;
        for(int i=0;i<m;i++){
            b[i]=j;
            if(j+a[i]-1>n){
                System.out.println(-1);
                return;
            }
            if(temp<=a[i]-1){
                j=j+a[i];
                j=j-(int)temp;
                temp=0;
            }
            else{
                temp=temp-(a[i]-1);
                j++;
            }
        }
        for(int i=0;i<m;i++)sb.append(b[i]+" ");
        System.out.println(sb);
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
