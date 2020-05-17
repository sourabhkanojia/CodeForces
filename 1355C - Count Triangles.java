import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
        int[] count=new int[d+1];
        for(int i=c-b;i>=0;i--){
            count[i]++;
            count[i+(d-c+1)]--;
        }
        for(int i=1;i<count.length;i++)count[i]+=count[i-1];
        long ans=0;
        for(int i=0;i<count.length;i++){
            long x=-1;
            if(i<a) x=b-a+1;
            else if(i<=b) x=b-i;
            else break;
            if(x>0)ans+=(long)count[i]*x;
        }
        System.out.println(ans);
    }
}
class Node{
    int count,i;
    public Node(int count,int i){
        this.count=count;
        this.i=i;
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
