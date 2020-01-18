import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int[] arr=new int[(int)(1e7+1)];
        for(int i=0;i<n;i++)arr[sc.nextInt()]++;
        int[] factor=new int[(int)(1e7+1)];
        boolean[] prime=new boolean[(int)(1e7+1)];

        for(int i=2;i<prime.length;i++){
            if(prime[i])continue;
            int q=0;
            for(int j=i;j<prime.length;j+=i){
                prime[j]=true;
                q+=arr[j];
            }
            factor[i]=q;
        }
        for(int i=1;i<factor.length;i++)factor[i]+=factor[i-1];
        int m=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(m-->0){
            int l=Math.min(sc.nextInt(),(int)(1e7+1)),r=Math.min(sc.nextInt(),(int)1e7);
            sb.append(factor[r]-factor[l-1]+"\n");
        }
        System.out.println(sb);
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

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

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
