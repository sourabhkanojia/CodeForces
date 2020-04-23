import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(),k=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            HashMap<Integer,Integer> hm=new HashMap<>();
            int[] presum=new int[2*k+2];
            for(int i=0;i<n/2;i++){
                int temp=a[i]+a[n-1-i];
                hm.put(temp,hm.getOrDefault(temp,0)+1);
                int min=Math.min(a[i],a[n-1-i]);
                int max=Math.max(a[i],a[n-1-i]);
                presum[min+1]++;
                presum[max+k+1]--;
            }
//            System.out.println(hm);
            for(int i=1;i<presum.length;i++)presum[i]+=presum[i-1];
//            for(int i=0;i<presum.length;i++) System.out.print(presum[i]+" ");
//            System.out.println();
            int pairs=n/2;
            int min=Integer.MAX_VALUE;
            for(int i=1;i<presum.length;i++){
                int count=0;
                int zeroChange=hm.getOrDefault(i,0);
                int oneChange=presum[i];
                int twoChange=pairs-oneChange;
                count=2*twoChange;
                count+=(oneChange-zeroChange);
                min=Math.min(min,count);
            }
            sb.append(min+"\n");
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
