import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            char[] c=sc.next().toCharArray();
            int i=0;
            int one=-1,two=-1,three=-1,min=Integer.MAX_VALUE;
            while(i<c.length){
                if(c[i]=='1')one=i;
                else if(c[i]=='2')two=i;
                else three=i;
                if(one!=-1 && two!=-1 && three!=-1){
                    int left=Math.min(one,Math.min(two,three));
                    int right=Math.max(one,Math.max(two,three));
                    min=Math.min(min,right-left+1);
                }
                i++;
            }
            sb.append((min==Integer.MAX_VALUE?0:min)+"\n");
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
