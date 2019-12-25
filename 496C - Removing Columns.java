import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[][] arr=new char[n][m];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLine().toCharArray();
        }
        if(n==1) System.out.println(0);
        else{
            int count=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n-1;j++){
                    if(arr[j][i]<=arr[j+1][i])continue;
                    else {
                        boolean z=false;
                        for(int k=0;k<i;k++){
                            if(arr[j][k]!='?' && arr[j][k]<arr[j+1][k]){
                                z=true;
                                break;
                            }
                        }
                        if(!z) {
                            count++;
                            for (int k = 0; k < n; k++) arr[k][i] = '?';
                            break;
                        }
                    }
                }
            }
            System.out.println(count);
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

