import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        if(n<=3) System.out.println("NO");
        else if(n%2==1){
            sb.append("YES\n");
            for (int i=n;i>5;i-=2)sb.append(i+" - "+(i-1)+" = "+1+"\n");
            int ones=(n-5)/2 + 1;
            for (int i=1;i<ones;i++)sb.append(1+" * "+1+" = "+1+"\n");
            sb.append(3+" * "+4+" = "+12+"\n");
            sb.append(5+" - "+1+" = "+4+"\n");
            sb.append(4+" - "+2+" = "+2+"\n");
            sb.append(12+" * "+2+" = "+24+"\n");
            System.out.println(sb);
        }
        else{
            sb.append("YES\n");
            for (int i=n;i>4;i-=2)sb.append(i+" - "+(i-1)+" = "+1+"\n");
            int ones=(n-4)/2 + 1;
            for (int i=1;i<ones;i++)sb.append(1+" * "+1+" = "+1+"\n");
            sb.append(1+" * "+2+" = "+2+"\n");
            sb.append(2+" * "+3+" = "+6+"\n");
            sb.append(6+" * "+4+" = "+24+"\n");
            System.out.print(sb);
        }
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
