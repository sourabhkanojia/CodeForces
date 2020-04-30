import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        StringBuilder ans;
        while(t-->0){
            ans=new StringBuilder();
            String s=sc.next();
            if(s.length()<=2) {
                sb.append(s + "\n");
                continue;
            }
            int zero=0,one=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0')zero++;
                else one++;
            }
            if(zero==0 || one==0){
                sb.append(s+"\n");
                continue;
            }
            for(int i=0;i<s.length();i++)ans.append("01");
            sb.append(ans+"\n");
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
