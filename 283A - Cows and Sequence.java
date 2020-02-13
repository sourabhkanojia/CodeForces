import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>(200000);
        arr.add(0);
        int[] temp=new int[200000];
        long total=0;
        StringBuilder sb=new StringBuilder();
        while(n-->0){
            int t=sc.nextInt();
            if(t==1){
                int a=sc.nextInt(),x=sc.nextInt();
                total+=a*x;
                temp[a-1]=temp[a-1]+x;
            }
            else if(t==2){
                int k=sc.nextInt();
                arr.add(k);
                total+=k;
            }
            else{
                int size=arr.size()-1;
                total-=arr.remove(size);
                total-=temp[size];
                temp[size-1]+=temp[size];
                temp[size]=0;
            }
            sb.append((double)total/arr.size()+"\n");
        }
        System.out.println(sb);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

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
