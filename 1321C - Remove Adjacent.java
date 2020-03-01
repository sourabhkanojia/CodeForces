import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static int max=0;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder(sc.next());
        dfs(sb,0);
        System.out.println(max);
    }
    static void dfs(StringBuilder s,int m){
        if(s.length()==1)return;
        char c='a';
        int index=-1;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && s.charAt(i)-1==s.charAt(i+1) && s.charAt(i)>c){
                index=i;
                c=s.charAt(i);
            }
            if(i-1>=0 && s.charAt(i)-1==s.charAt(i-1) && s.charAt(i)>c){
                index=i;
                c=s.charAt(i);
            }
        }
        for(int i=0;i<s.length();i++){
            if(i==index) {
                if (m + 1 > max) max = m + 1;
                StringBuilder temp = new StringBuilder(s.toString());
                dfs(temp.replace(i, i + 1, ""), m + 1);
            }
        }
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
