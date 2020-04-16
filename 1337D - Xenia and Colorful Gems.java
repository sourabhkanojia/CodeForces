import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int r=sc.nextInt(),g=sc.nextInt(),b=sc.nextInt();
            Long[] A=new Long[r],B=new Long[g],C=new Long[b];
            for(int i=0;i<r;i++)A[i]=sc.nextLong();
            for(int i=0;i<g;i++)B[i]=sc.nextLong();
            for(int i=0;i<b;i++)C[i]=sc.nextLong();
            Arrays.sort(A);Arrays.sort(B);Arrays.sort(C);
            int i=0,j=0,k=0;
            long ans=(A[i]-B[j])*(A[i]-B[j])+(B[j]-C[k])*(B[j]-C[k])+(C[k]-A[i])*(C[k]-A[i]);
            while(true){
                long x=Long.MAX_VALUE,y=Long.MAX_VALUE,z=Long.MAX_VALUE;
                if(i+1<r)x=(A[i+1]-B[j])*(A[i+1]-B[j])+(B[j]-C[k])*(B[j]-C[k])+(C[k]-A[i+1])*(C[k]-A[i+1]);
                if(j+1<g)y=(A[i]-B[j+1])*(A[i]-B[j+1])+(B[j+1]-C[k])*(B[j+1]-C[k])+(C[k]-A[i])*(C[k]-A[i]);
                if(k+1<b)z=(A[i]-B[j])*(A[i]-B[j])+(B[j]-C[k+1])*(B[j]-C[k+1])+(C[k+1]-A[i])*(C[k+1]-A[i]);
                if(x==Long.MAX_VALUE && y==Long.MAX_VALUE && z==Long.MAX_VALUE)break;
                if(x<=y && x<=z){
                    ans=Math.min(ans,x);
                    i++;
                }
                else if(y<=x && y<=z){
                    ans=Math.min(ans,y);
                    j++;
                }
                else{
                    ans=Math.min(ans,z);
                    k++;
                }
            }
            sb.append(ans+"\n");
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
