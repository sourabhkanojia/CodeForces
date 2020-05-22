import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int[] tree;
    static int size;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),q=sc.nextInt();
        size=n;
        tree=new int[n+1];
        for(int i=0;i<n;i++) update(sc.nextInt(),1);

        while(q-->0){
            int x=sc.nextInt();
            if(x>0)update(x,1);
            else{
                x=Math.abs(x);
                int l=1,r=size,ans=-1;
                while(l<=r){
                    int mid=l+(r-l)/2;
                    int temp=sum(mid);
                    if(temp>=x){
                        r=mid-1;
                        ans=mid;
                    }
                    else l=mid+1;
                }
                update(ans,-1);
            }
        }
        for(int i=1;i<=n;i++){
            if(tree[i]>0){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    // update position by delta
    static void update(int i,int delta){
        while(i<=size){
            tree[i]+=delta;
            i+=(i&-i);
        }
    }
    // compute the prefix sum value[1,i]
    static int sum(int i){
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=(i&-i);
        }
        return sum;
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
//    int nextInt() { return Integer.parseInt(next()); }
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
