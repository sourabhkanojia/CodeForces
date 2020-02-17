import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        while (t-->0){
            long n=sc.nextLong();
            int m=sc.nextInt();
            int bit[]=new int[61];
            long sum=0;
            for (int i=0;i<m;i++){
                int temp=sc.nextInt();
                sum+=temp;
                int j=0;
                while ((temp&(1<<j))==0)j++;
                bit[j]++;
            }
            if (sum<n) {
                System.out.print("-1\n");
                continue;
            }
            int res=0;
            for (int i=0;i<60;i++){
                if ((n&(1L<<i))!=0){
                    if (bit[i]==0){
                        int j=i+1;
                        while (bit[j]==0)j++;
                        while (j!=i){
                            bit[j]--;
                            j--;
                            bit[j]+=2;
                            res++;
                        }
                    }
                    bit[i]--;
                }
                bit[i+1]+=bit[i]/2;
            }
            System.out.println(res);
        }
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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
