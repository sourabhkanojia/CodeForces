import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
           int x=sc.nextInt();
           hs.add(x);
           q.add(x-1);
           q.add(x+1);
        }
        long sum = 0;
        q.add(null);
        int i=1;
        LinkedList<Integer> ll=new LinkedList<>();
        while(ll.size()!=m) {
            Integer temp=q.poll();
            if(temp==null){
                q.add(null);
                i++;
            }
            else {
                if (hs.contains(temp)) continue;
                hs.add(temp);
                ll.add(temp);
                q.add(temp - 1);
                q.add(temp + 1);
                sum += i;
            }
        }
        System.out.println(sum);
        for(int j:ll) System.out.print(j+" ");

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
