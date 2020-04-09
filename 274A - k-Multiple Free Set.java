import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        long k=sc.nextInt();
        long[] arr=new long[n];
        HashSet<Long> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(arr[i]%k==0)hs.add(arr[i]/k);
            hs.add(arr[i]);
        }
        int count=0;
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--){
            if(hs.contains(arr[i])){
                hs.remove(arr[i]);
                if(arr[i]%k==0)hs.remove(arr[i]/k);
                count++;
            }
        }
        System.out.println(count);
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
