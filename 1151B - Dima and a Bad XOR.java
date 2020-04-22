import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)arr[i][j]=sc.nextInt();
        }
        int xor=0;
        for(int i=0;i<n;i++)xor=xor^arr[i][0];
        int x=-1,y=-1;
        boolean z=false;
        if(xor==0){
            for(int i=0;i<n;i++){
                for(int j=1;j<m;j++){
                    if(arr[i][j]!=arr[i][0]){
                        z=true;
                        x=i;y=j;
                        break;
                    }
                }
                if(z)break;
            }
            if(!z){
                System.out.println("NIE");
                return;
            }
        }
        sb.append("TAK\n");
        for(int i=0;i<n;i++){
            if(x==i)sb.append(y+1+" ");
            else sb.append(1+" ");
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
