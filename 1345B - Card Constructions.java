import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        TreeSet<Long> treeSet=new TreeSet<>();
        int i=1;
        while(true){
            long temp=i*(3*i+1)/2;
            if(temp>1e9)break;
            else treeSet.add(temp);
            i++;
        }
        while(t-->0){
            long n=sc.nextInt();
            int count=0;
            while(true){
                Long temp=treeSet.floor(n);
                if(temp!=null)count++;
                else break;
                n-=temp;
            }
            sb.append(count+"\n");
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
