import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int[][] dp;
    static String[] digit = {"1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010", "1111111", "1111011"};
    static String[] states;
    static int[][] changesNeed;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        sb = new StringBuilder();
        n=sc.nextInt();k=sc.nextInt();
        dp=new int[n][k+1];
        states=new String[n];
        changesNeed=new int[n][10];
        for(int i=0;i<n;i++)states[i]=sc.next();
        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                changesNeed[i][j]=changesRequired(states[i],digit[j]);
            }
        }
        for(int[] i:dp)Arrays.fill(i,-1);
        int found=solve(0,k);
        if(found==0) System.out.println(-1);
        else{
            getAns(0,k);
            System.out.println(sb.toString());
        }
    }
    static int changesRequired(String a,String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='0' && b.charAt(i)=='1')count++;
            else if(a.charAt(i)=='1' && b.charAt(i)=='0')return -1;
        }
        return count;
    }
    static int solve(int i,int k){
        if(i>=n){
            if(k==0)return 1;
            else return 0;
        }
        if(dp[i][k]!=-1)return dp[i][k];
        int ans=0;
        for(int j=9;j>=0 && ans==0;j--){
            int count=changesNeed[i][j];
            if(count!=-1 && count<=k){
                ans=solve(i+1,k-count);
            }
        }
        return dp[i][k]=ans;
    }
    static void getAns(int pos, int rem) {
        if (pos >= n) {
            return;
        }
        for (int i = 9; i >= 0; i--) {
            int count = changesNeed[pos][i];
            if (count != -1 && count <= rem) {
                int ans = solve(pos + 1, rem - count);
                if (ans == 1) {
                    sb.append(i);
                    getAns(pos + 1, rem - count);
                    return;
                }
            }
        }
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
