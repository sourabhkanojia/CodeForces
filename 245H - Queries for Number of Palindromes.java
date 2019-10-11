import java.util.*;
import java.io.*;

public class problems {
    public static void main(String args[] ) throws Exception {
        FastReader sc=new FastReader();
        String s=sc.nextLine();
        int n=s.length();
        s=" "+s;
        int[][] dp=new int[5001][5001];
        int[][] pal=new int[5001][5001];
        // Length of 1
        for(int i=1;i<=n;i++){
            pal[i][i]=1;
        }

        // Length of 2
        for(int i=1;i<n;i++){
            if(s.charAt(i)== s.charAt(i+1)){
                pal[i][i+1]=1;
            }
        }

        for(int len=0;len<n-2;len++){
            //i is a starting index
            for(int i=1;i<n-len;i++){
                //if we have a palindrome ans the same letter on both sides of the palindrome
                if(pal[i][i+len]==1 && s.charAt(i-1)== s.charAt(i+len+1)){
                    pal[i-1][i+len+1]=1;
                }
            }
        }

        // Prefix Sum 2-d
        for (int i=1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = pal[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        StringBuilder sb=new StringBuilder();
        int q=sc.nextInt();
        while(q-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int ans=0;

            ans=dp[y][y] - dp[x-1][y] - dp[y][x-1] + dp[x-1][x-1];
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
