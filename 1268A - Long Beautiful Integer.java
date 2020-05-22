import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        String s=sc.next();
        int[] a=new int[n+1],b=new int[n+1];
        for(int i=0;i<n;i++)a[i+1]=s.charAt(i)-'0';
        for(int i=1;i<=n;i++){
            if(i<=k)b[i]=a[i];
            else b[i]=b[i-k];
        }
        boolean z=true;
        for(int i=k+1;i<=n;i++){
            if(a[i]==b[i])continue;
            else if(b[i]<a[i])z=false;
            break;
        }
        if(z){
            sb.append(n+"\n");
            for(int i=1;i<=n;i++)sb.append(b[i]);
            System.out.println(sb);
            return;
        }
        int pos=k;
        while(pos>=1 && b[pos]==9){
            b[pos]=0;
            pos--;
        }
        b[pos]++;

        for(int i=k+1;i<=n;i++){
            b[i]=b[i-k];
        }
        if(pos==0)sb.append((n+1)+"\n");
        else sb.append(n+"\n");
        for(int i=1;i<=n;i++)sb.append(b[i]);
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
//  int nextInt() { return Integer.parseInt(next()); }
    int nextInt() throws IOException {
        int out = 0;
        boolean neg = false;
        while(true) {
            int get = br.read();
            if(get == -1) break;

            char a = (char)get;

            if(a == '-') neg = true;
            else if(a >= '0' && a <= '9') {
                out *= 10;
                out += a - '0';
            }
            else if(out != 0) break;
        }
        if(neg) out = -out;
        return out;
    }
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
