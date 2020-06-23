import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static boolean[] vis;
    static boolean z=false;
    static LinkedList<Integer> vertex;
    public static void main(String[] args) throws Exception {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        adj=new LinkedList[k];
        for(int i=0;i<k;i++)adj[i]=new LinkedList<>();
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            if(u<k && v<k) {
                adj[u].add(v);
                adj[v].add(u);
            }
        }
        vis=new boolean[k];
        vertex=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(!vis[i])cycle(i,i);
            if(z)break;
        }

        if(z){
            sb.append(2+"\n"+vertex.size()+"\n");
            for(int i:vertex)sb.append((i+1)+" ");
        }
        else{
            int[] bi=new int[k];
            Arrays.fill(bi,-1);
            for(int i=0;i<k;i++){
                if(bi[i]==-1)bipartite(i,bi,0);
            }
            int K=(k+1)/2;
            int zero=0,one=0;
            for(int i=0;i<k;i++){
                if(bi[i]==0)zero++;
                else one++;
            }
            sb.append(1+"\n");
            int c=zero>=one?0:1;
            for(int i=0;i<k && K>0;i++){
                if(bi[i]==c){
                    sb.append((i+1)+" ");
                    K--;
                }
            }
        }
        System.out.println(sb);
    }
    static int startVertex=-1;
    static void cycle(int node,int par){
        if(vis[node]){
            startVertex=node;
            z=true;
            return;
        }
        vis[node]=true;
        for(int i:adj[node]){
            if(i!=par) {
                if (!z) cycle(i, node);
            }
        }
        if(z){
            if(startVertex!=-1)vertex.addFirst(node);
            if(startVertex==node)startVertex=-1;
        }
    }
    static void bipartite(int node,int[] bi,int c){
        bi[node]=c;
        for(int i:adj[node]){
            if(bi[i]==-1){
                if(c==0)bipartite(i,bi,1);
                else bipartite(i,bi,0);
            }
        }
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
