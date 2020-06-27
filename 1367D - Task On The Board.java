import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int maxg = (int)(1e7);
    public static void main(String[] args) throws Exception {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        long maxl = (long)(1e18+5);
        while(t-->0){
            String str = sc.next();
            int[]freq = new int[26];
            for(int i=0;i<str.length();i++)freq[str.charAt(i)-'a']++;

            int n = str.length();
            int m = sc.nextInt();
            Point[]b = new Point[m];
            for(int i=0;i<m;i++) b[i] = new Point(sc.nextInt(),i);

            char[]ans = new char[m];
            boolean[] vis = new boolean[str.length()];
            int[] ind = new int[str.length()];
            while(true) {
                int i = 0;
                ArrayList<Integer>indices = new ArrayList<Integer>();
                for(i=0;i<m;i++)if(b[i].x==0)indices.add(b[i].y);

                if(indices.size() == 0)break;
                int need = indices.size();
                char x =  find(freq,need);
                for(Integer cur : indices) {
                    ans[cur] = x;
                }
                for(int j=0;j<m;j++) {
                    if(b[j].x == 0)
                        b[j].x = maxg;
                    else{
                        for(Integer cur : indices)
                            b[j].x -= Math.abs(b[j].y - cur);
                    }

                }
            }
            for(int i=0;i<m;i++)sb.append(ans[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static char find(int[]freq,int need) {
        for(int i=25;i>=0;i--) {
            if(freq[i] >= need) {
                for(int j=i;j<26;j++) {
                    freq[j] = 0;
                }
                return (char)('a'+i);
            }
        }
        return '\0';
    }
}
/*********************************************************************************
 ----------------------------------SOLUTION END-----------------------------------
 *********************************************************************************/
class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
    public int read() {
        if (numChars==-1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try { numChars = stream.read(buf); }
            catch (IOException e) { throw new InputMismatchException(); }

            if(numChars <= 0) return -1;
        }
        return buf[curChar++];
    }
    public String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace(); }
        return str;
    }
    public int nextInt() {
        int c = read();
        while(isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if(c<'0'||c>'9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }
    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }
    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9') throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
    public String readString() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        StringBuilder res = new StringBuilder();
        do { res.appendCodePoint(c);c = read();}
        while (!isSpaceChar(c));
        return res.toString();
    }
    public boolean isSpaceChar(int c) {
        if (filter != null) return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
    public String next() { return readString();}
    public interface SpaceCharFilter { public boolean isSpaceChar(int ch);}
}
