import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] updateTime=new int[n];
        int m=sc.nextInt();
        int[] update=new int[m];
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            if(x==1){
                int pos=sc.nextInt()-1,val=sc.nextInt();
                arr[pos]=val;
                updateTime[pos]=i;
            }
            else update[i]=sc.nextInt();
        }
        for(int i=m-2;i>=0;i--)update[i]=Math.max(update[i],update[i+1]);
        for(int i=0;i<n;i++){
            sb.append(Math.max(arr[i],update[updateTime[i]])+" ");
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
