import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)arr[i] = sc.nextInt();
        int l, r, p = 0, max = -1;
        int[] ans = new int[n];
        for(int i = 1; i <= n;) {
            l = r = i;
            while(l > 1 && arr[l - 1] % arr[i] == 0) l--;
            while(r < n && arr[r + 1] % arr[i] == 0) r++;

            i = r + 1;
            r -= l;
            if(r > max) {
                p = 0;
                max = r;
            }
            if(r == max) {
                ans[p++] = l;
            }
        }
        sb.append(p+" "+max+"\n");
        for(int i=0;i<p;i++)sb.append(ans[i]+" ");
        System.out.println(sb);
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
