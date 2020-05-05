import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), k = sc.nextInt();
            Set<Integer> hs = new HashSet<>();
            for (int i = 0; i < n; i++) hs.add(sc.nextInt());
            if (hs.size() > k){
                sb.append(-1+"\n");
                continue;
            }
            int[] a=new int[hs.size()];
            int i=0;
            for(int j:hs)a[i++]=j;
            sb.append(n*k+"\n");
            for(i=0;i<n;i++){
                for(int j=0;j<k;j++){
                    if(j<a.length)sb.append(a[j]+" ");
                    else sb.append(1+" ");
                }
            }
            sb.append("\n");
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
