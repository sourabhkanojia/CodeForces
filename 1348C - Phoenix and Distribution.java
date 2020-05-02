import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt(), k = sc.nextInt();
            String s = sc.next();
            Character[] c = new Character[n];
            for (int i = 0; i < n; i++) c[i] = s.charAt(i);
            Arrays.sort(c);
            LinkedList<String> ll = new LinkedList<>();
            StringBuilder temp = new StringBuilder();


            temp.append(c[0]);
            for (int i = k; i < n; i++) temp.append(c[i]);
            for (int i = 1; i < k; i++) {
                ll.add(Character.toString(c[i]));
            }
            ll.add(temp.toString());
            Collections.sort(ll);
            String ans1=ll.getLast();
            
            StringBuilder[] sbuilder=new StringBuilder[k];
            String[] str=new String[k];
            for(int i=0;i<k;i++)sbuilder[i]=new StringBuilder();

            for(int i=0;i<n;i++){
                sbuilder[i%k].append(c[i]);
            }
            for(int i=0;i<k;i++){
                str[i]=sbuilder[i].toString();
            }
            Arrays.sort(str);
            String ans2=str[k-1];
            
            if(ans1.compareTo(ans2)<=0)sb.append(ans1+"\n");
            else sb.append(ans2+"\n");
        }
        System.out.println(sb);
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
