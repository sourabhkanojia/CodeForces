import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] vis;
    static int countG;
    static boolean Bpresent =false;
    public static void main(String[] args) throws Exception {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            char[][] carray=new char[n][m];
            vis=new boolean[n][m];
            for(int i=0;i<n;i++){
                carray[i]=sc.next().toCharArray();
            }
            countG=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(carray[i][j]=='G')countG++;
                }
            }
            boolean found=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(carray[i][j]=='B'){
                        if(i+1<n){
                            if(carray[i+1][j]=='.')carray[i+1][j]='#';
                            else if(carray[i+1][j]=='G'){
                                found=true;
                                break;
                            }
                        }
                        if(i-1>=0){
                            if(carray[i-1][j]=='.')carray[i-1][j]='#';
                            else if(carray[i-1][j]=='G'){
                                found=true;
                                break;
                            }
                        }
                        if(j+1<m){
                            if(carray[i][j+1]=='.')carray[i][j+1]='#';
                            else if(carray[i][j+1]=='G'){
                                found=true;
                                break;
                            }
                        }
                        if(j-1>=0){
                            if(carray[i][j-1]=='.')carray[i][j-1]='#';
                            else if(carray[i][j-1]=='G'){
                                found=true;
                                break;
                            }
                        }
                    }
                }
                if(found)break;
            }
            if(found){
                sb.append("NO\n");
                continue;
            }
            if(carray[n-1][m-1]=='#'){
                if(countG>0)sb.append("NO\n");
                else sb.append("YES\n");
                continue;
            }
            Bpresent =false;
            solve(carray,n-1,m-1,n,m);
            if(Bpresent)sb.append("NO\n");
            else{
                if(countG==0)sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
    static void solve(char[][] c, int i, int j, int n, int m){
        vis[i][j]=true;
        if(c[i][j]=='G')countG--;
        else if(c[i][j]=='B'){
            Bpresent =true;
            return;
        }
        if(i+1<n && c[i+1][j]!='#' && !vis[i+1][j]) solve(c,i+1,j,n,m);

        if(i-1>=0 && c[i-1][j]!='#' && !vis[i-1][j]) solve(c,i-1,j,n,m);

        if(j+1<m && c[i][j+1]!='#' && !vis[i][j+1]) solve(c,i,j+1,n,m);

        if(j-1>=0 && c[i][j-1]!='#' && !vis[i][j-1]) solve(c,i,j-1,n,m);

    }
}
/******************************************
 SOLUTION END
 ******************************************/
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
        do {
            res.appendCodePoint(c);
            c = read();
        }
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
