import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int q=sc.nextInt();
        while(q-->0) {
            int n = sc.nextInt(), k = sc.nextInt();
            char[] c = sc.nextLine().toCharArray();
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            StringBuilder sb3=new StringBuilder();
            sb1.append("R");sb2.append("G");sb3.append("B");
            for(int i=1;i<k;i++){
                if(i%3==1){
                    sb1.append("G");
                    sb2.append("B");
                    sb3.append("R");
                }
                else if(i%3==2){
                    sb1.append("B");
                    sb2.append("R");
                    sb3.append("G");
                }
                else{
                    sb1.append("R");
                    sb2.append("G");
                    sb3.append("B");
                }
            }
            int max=0;
            for(int i=0;i<=n-k;i++){
                int count1=0,count2=0,count3=0;
                for(int j=0;j<k;j++){
                    if(sb1.charAt(j)==c[i+j])count1++;
                    if(sb2.charAt(j)==c[i+j])count2++;
                    if(sb3.charAt(j)==c[i+j])count3++;
                }
                max=Math.max(max,Math.max(count1,Math.max(count2,count3)));
            }
            if(max>=k)sb.append(0+"\n");
            else sb.append((k-max)+"\n");
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
