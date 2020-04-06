import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        long x=0;
        int l=sc.nextInt();
        long m=(long)(Math.pow(2,32)-1);
        LinkedList<Long> ll=new LinkedList<>();
        ll.add(1l);
        boolean z=true;
        for(int i=0;i<l;i++){
            if(z) {
                String s=sc.next();
                if(s.equals("for")) {
                    long temp = ll.getLast() * sc.nextLong();
                    if(temp>m)ll.add(m+1);
                    else ll.add(temp);
                }
                else if(s.equals("end"))ll.removeLast();
                else{
                    x+=ll.getLast();
                    if(x>m)z=false;
                }
            }
            else sc.nextLine();
        }
        if(z) System.out.println(x);
        else System.out.println("OVERFLOW!!!");
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
