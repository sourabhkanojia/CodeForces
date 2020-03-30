import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        ArrayList<Integer> arr[]=new ArrayList[(int) 2e5+1];
        for (int i=0;i<arr.length;i++)arr[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=a[i];
            int curr=0;
            while(x!=0){
                arr[x].add(curr);
                x/=2;
                curr++;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            Collections.sort(arr[i]);
            if(arr[i].size()<k)continue;
            int sum=0;
            for (int j=0;j<k;j++){
                sum+=arr[i].get(j);
            }
            min=Math.min(min,sum);
        }
        System.out.println(min);
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
