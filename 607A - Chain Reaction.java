import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        Point[] p=new Point[n];int[] dp=new int[n];
        for(int i=0;i<n;i++)p[i]=new Point(sc.nextInt(),sc.nextInt());
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x-o2.x;
            }
        });
        int max=0;
        for(int i=0;i<n;i++){
            int l=0,r=i-1,ans=-1,diff=p[i].x-p[i].y-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(p[mid].x<=diff){
                    ans=mid;
                    l=mid+1;
                }
                else r=mid-1;
            }
            dp[i]=ans==-1?1:dp[ans]+1;
            max=Math.max(max,dp[i]);
        }
        System.out.println(n-max);
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
