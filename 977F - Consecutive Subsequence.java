import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] dp=new int[n];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(!hm.containsKey(arr[i]-1))dp[i]=1;
            else dp[i]=dp[hm.get(arr[i]-1)]+1;
            hm.put(arr[i],i);
        }
        int max=0;
        int x=-1;
        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max=dp[i];
                x=arr[i];
            }
        }
        sb.append(max+"\n");
        x=x-max+1;
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                sb.append((i+1)+" ");
                x++;
            }
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
