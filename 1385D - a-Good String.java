import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        InputReader sc = new InputReader(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            System.out.println(solve(s,'a'));
        }
    }
    public static int solve(String s,char c){
        if(s.length()==1){
            if(s.charAt(0)==c)return 0;
            else return 1;
        }
        int one=0,two=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(i<n/2){
                if(s.charAt(i)==c)one++;
            }
            else{
                if(s.charAt(i)==c)two++;
            }
        }
        c++;
        int left=solve(s.substring(0,n/2),c);
        int right=solve(s.substring(n/2,n),c);

        return Math.min((n/2)-one+right,(n/2)-two+left);
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
