import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        char[] c=sc.next().toCharArray();
        int[][] dp=new int[26]
        int q=sc.nextInt();
        while(q-->0){
            int x=sc.nextInt();
            if(x==1){
                int i=sc.nextInt()-1;
                char z=sc.next().charAt(0);
                ts[c[i]-'a'].remove(i);
                c[i]=z;
                ts[c[i]-'a'].add(i);
            }
            else{
                int l=sc.nextInt()-1,r=sc.nextInt()-1;
                int count=0;
                for(int i=0;i<26;i++){
                    Integer temp=ts[i].ceiling(l);
                    if(temp!=null && temp<=r){
                        count++;
                    }
                }
                sb.append(count+"\n");
            }
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
