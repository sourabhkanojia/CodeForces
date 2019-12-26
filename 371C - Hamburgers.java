import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception,ArithmeticException {
        FastReader sc = new FastReader();
        String s=sc.next();
        int[] rec=new int[3];
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='B')rec[0]++;
            if (s.charAt(i)=='S')rec[1]++;
            if (s.charAt(i)=='C')rec[2]++;
        }
        int[] n=new int[3];
        for (int i=0;i<3;i++)n[i]=sc.nextInt();
        int[] p=new int[3];
        for (int i=0;i<3;i++)p[i]=sc.nextInt();
        long rr=sc.nextLong();
        long l=0,r=(long)1e13;
        long ans=0;
        while (l<=r){
            long mid=l+(r-l)/2;
            long money=Math.max((rec[0]*mid-n[0]),0)*p[0]+Math.max((rec[1]*mid-n[1]),0)*p[1]+Math.max((rec[2]*mid-n[2]),0)*p[2];
            if (money<=rr){
                ans=mid;
                l=mid+1;
            }else r=mid-1;
        }
        System.out.println(ans);
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

