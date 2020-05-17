import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt(),s=sc.nextInt();
        if(s>=2*n){
            System.out.println("YES");
            int temp=s/n;
            int r=s%n;
            if(r==0){
                for(int i=1;i<=n;i++) sb.append(temp+" ");
            }
            else{
                for(int i=1;i<n;i++)sb.append(temp+" ");
                sb.append(r+temp);
            }
            sb.append("\n"+1);
            System.out.println(sb);
        }
        else System.out.println("NO");
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
