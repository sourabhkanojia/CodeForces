import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        char[] c=sc.next().toCharArray();
        long evenA=0,evenB=0,oddA=0,oddB=0,even=0,odd=0;
        for(int i=0;i<c.length;i++){
            if(i%2==0){
                if(c[i]=='a'){
                    evenA++;
                    even+=oddA;
                    odd+=evenA;
                }
                else{
                    evenB++;
                    even+=oddB;
                    odd+=evenB;
                }
            }
            else{
                if(c[i]=='a'){
                    oddA++;
                    even+=evenA;
                    odd+=oddA;
                }
                else{
                    oddB++;
                    even+=evenB;
                    odd+=oddB;
                }
            }
        }
        System.out.println(even+" "+odd);
    }

    static class FastReader {
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
}
