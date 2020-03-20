import java.awt.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    static int mod=998244353;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        Point[] p=new Point[n];
        for(int i=0;i<n;i++)p[i]=new Point(sc.nextInt(),i);
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x-o2.x;
            }
        });
        Integer[] arr=new Integer[k];
        int temp=0;
        long ans=0,sol=1;
        for(int i=n-1;i>=n-k;i--){
            ans+=(long)p[i].x;
            arr[temp++]=p[i].y;
        }
        if(k==1){
            System.out.println(ans+" 1");
            return;
        }
        Arrays.sort(arr);
        for(int i=0;i<k-1;i++){
            sol=(sol*(arr[i+1]-arr[i]))%mod;
        }
        System.out.println(ans+" "+sol);
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
