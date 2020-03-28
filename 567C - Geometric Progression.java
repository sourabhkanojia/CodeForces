import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        HashMap<Long,Long> right=new HashMap<>();
        HashMap<Long,Long> left=new HashMap<>();
        for(int i=n-1;i>=2;i--){
            left.put(arr[i],left.getOrDefault(arr[i],0l)+1);
        }
        right.put((long)arr[0],1l);
        long count=0;
        for(int i=1;i<n-1;i++){
            if(arr[i]%k==0 && right.containsKey(arr[i]/k) && left.containsKey(arr[i]*k)){
                long a=right.get(arr[i]/k),b=left.get(arr[i]*k);
                count+=a*b;
            }
            right.put(arr[i],right.getOrDefault(arr[i],0l)+1);
            long temp=left.get(arr[i+1]);
            if(temp>1)left.put(arr[i+1],temp-1);
            else left.remove(arr[i+1]);
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
