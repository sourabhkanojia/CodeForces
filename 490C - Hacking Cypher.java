import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        char[] s=sc.next().toCharArray();
        int a=sc.nextInt(),b=sc.nextInt(),n=s.length;
        long m=1;
        long[] right=new long[n];
        long[] left=new long[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1)right[i]=(m*(s[i]-'0'))%b;
            else right[i]=(right[i+1]+m*(s[i]-'0'))%b;
            m=(m*10)%b;
        }
        for(int i=0;i<n-1;i++){
            if(i==0)left[i]=(s[i]-'0')%a;
            else left[i]=(left[i-1]*10+(s[i]-'0'))%a;
        }
        for(int i=0;i<n-1;i++){
            if(left[i]==0 && right[i+1]==0 && s[i+1]!='0'){
                sb.append("YES\n");
                for(int j=0;j<=i;j++)sb.append(s[j]);
                sb.append("\n");
                for(int j=i+1;j<n;j++)sb.append(s[j]);
                System.out.println(sb);
                return;
            }
        }
        System.out.println("NO");
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
