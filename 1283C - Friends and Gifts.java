import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Candidate {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int[] a=new int[n];
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)hs.add(i+1);
 
        LinkedList<Integer> ll=new LinkedList<>();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(a[i]!=0)hs.remove(a[i]);
        }
 
        for(int i:hs)ll.add(i);
        Collections.sort(ll,Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(a[i]==0){
                if(i+1==ll.get(0)){
                    a[i]=ll.remove(1);
                }
                else a[i]=ll.remove(0);
            }
        }
        for(int i=0;i<n;i++) System.out.print(a[i]+" ");
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
