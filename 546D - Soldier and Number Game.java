import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int[] prime=new int[(int)5e6+1];
        for(int i=2;i<prime.length;i++){
            if(prime[i]==0){
                prime[i]=1;
                for(int j=2*i;j<prime.length;j+=i){
                    prime[j]=prime[j/i]+1;
                }
            }
        }
        for(int i=1;i<prime.length;i++)prime[i]+=prime[i-1];
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt(),b=sc.nextInt();
            sb.append(prime[a]-prime[b]+"\n");
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
