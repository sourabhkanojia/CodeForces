import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static int mod=(int)1e9+7;
    static int[] v;
    static long[] min;
    static long[] plus;
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        ll=new LinkedList[n];
        for(int i=0;i<n;i++)ll[i]=new LinkedList<>();
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            ll[u].add(v);
            ll[v].add(u);
        }
        v=new int[n];min=new long[n];plus=new long[n];
        for(int i=0;i<n;i++)v[i]=sc.nextInt();
        dfs(0,0);
        System.out.println(min[0]+plus[0]);
    }
    static void dfs(int u,int par){
        for(int v:ll[u]){
            if(v==par)continue;;
            dfs(v,u);
            min[u]=Math.max(min[u],min[v]);
            plus[u]=Math.max(plus[u],plus[v]);
        }
        v[u]+=(plus[u]-min[u]);
        if(v[u]>=0)min[u]+=v[u];
        else plus[u]-=v[u];
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
