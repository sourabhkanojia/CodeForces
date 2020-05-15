import java.util.*;
import java.io.*;

public class Main {
    static boolean visit[][];
    static int value[];
    static int vis[][];
    static char map[][];
    static int count;

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        map=new char[n][m];
        visit =new boolean[n][m];
        for(int i=0;i<n;i++)map[i]=sc.next().toCharArray();
        vis=new int[n][m];
        value =new int[k+1];
        for(int i=1;i<=k;i++){
            int x=sc.nextInt()-1,y=sc.nextInt()-1;
            if(vis[x][y]==0){
                count=0;
                solve(x,y,i);
                value[i]=count;
                sb.append(count+"\n");
            }
            else sb.append(value[vis[x][y]]+"\n");
        }
        System.out.println(sb);
    }
    static void solve(int x, int y, int i) {
        visit[x][y] = true;
        if (map[x][y] == '*') {
            count++;
            return;
        }
        if (vis[x][y]!=0) return;
        vis[x][y] = i;
        solve(x + 1, y, i);
        solve(x, y + 1, i);
        solve(x - 1, y, i);
        solve(x, y - 1, i);
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
