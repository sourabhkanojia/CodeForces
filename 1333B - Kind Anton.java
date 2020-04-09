import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            for(int i=0;i<n;i++)b[i]=sc.nextInt();
            int one=n;
            for(int i=0;i<n;i++){
                if(a[i]==1){
                    one=i;
                    break;
                }
            }
            int negOne=n;
            for(int i=0;i<n;i++){
                if(a[i]==-1){
                    negOne=i;
                    break;
                }
            }
            boolean z=false;
            for(int i=0;i<=one && i<n;i++){
                if(a[i]<b[i]){
                    z=true;
                    break;
                }
            }
            for(int i=0;i<=negOne && i<n;i++){
                if(a[i]>b[i]){
                    z=true;
                    break;
                }
            }
            if(z)sb.append("NO\n");
            else sb.append("YES\n");
        }
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
