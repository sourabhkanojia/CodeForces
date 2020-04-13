import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t =sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            Integer[] arr=new Integer[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            Arrays.sort(arr);
            int l=0,r=n-1;
            LinkedList<Integer> ll=new LinkedList<>();
            while(l<=r){
                if(l!=r){
                    ll.addFirst(arr[r]);
                    ll.addFirst(arr[l]);
                }
                else ll.addFirst(arr[l]);
                l++;
                r--;
            }
            for(int i:ll)sb.append(i+" ");
            sb.append("\n");
        }
        System.out.println(sb);
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
