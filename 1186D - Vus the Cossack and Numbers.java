import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        double[] arr=new double[n];
        int[] b=new int[n];
        long sum=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextDouble();
            b[i]=(int)Math.ceil(arr[i]);
            sum+=b[i];
        }
        int i=0;
        while(sum>0){
            if(b[i]!=0 && arr[i]!=(int)arr[i]){
                b[i]--;
                sum--;
            }
            i++;
        }
        for(i=0;i<n;i++)sb.append(b[i]+"\n");
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
