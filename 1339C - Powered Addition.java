import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            long count=0;
            int sec=0;
            for(int i=1;i<n;i++){
               long diff=arr[i-1]-arr[i];
               if(diff<0)continue;
               sec=Math.max(sec,count(diff));
               arr[i]=arr[i-1];
            }
            sb.append(sec+"\n");
        }
        System.out.println(sb);
    }
    static int count(long diff){
        int sec=0;
        while(diff>0){
            diff>>=1;
            sec++;
        }
        return sec;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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
