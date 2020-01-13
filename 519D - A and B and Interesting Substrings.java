import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int[] arr=new int[26];
        for(int i=0;i<26;i++)arr[i]=sc.nextInt();
        String s=sc.nextLine();
        Map<Long,Integer>[] hm=new HashMap[26];
        for(int i=0;i<26;i++)hm[i]=new HashMap<>();
        long sum=0,sol=0;
        for(char c:s.toCharArray()){
            sol=sol+hm[c-'a'].getOrDefault(sum,0);
            sum=sum+arr[c-'a'];
            hm[c-'a'].put(sum,hm[c-'a'].getOrDefault(sum,0)+1);
        }
        System.out.println(sol);
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
