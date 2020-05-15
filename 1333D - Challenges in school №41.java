import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt(),count=0;
        char[] c=sc.next().toCharArray();
        LinkedList<LinkedList<Integer>> ll=new LinkedList<>();
        LinkedList<Integer> temp;
        for(int i=0;i<n;i++){
            temp=new LinkedList<>();
            boolean flag=false;
            for(int j=0;j<n-1;j++){
                if(c[j]=='R' && c[j+1]=='L'){
                    temp.add(j+1);
                    c[j]='L';
                    c[j+1]='R';
                    count++;
                    j++;
                    flag=true;
                }
            }
            if(!flag)break;
            else ll.add(temp);
        }
        if(count<k || ll.size()>k) System.out.println(-1);
        else{
            int[] z;
            int rem=k-ll.size();
            for(LinkedList<Integer> x:ll){
                int p=Math.max(x.size()-rem,1);
                rem-=(x.size()-p);
                sb.append(p+" ");
                z=new int[x.size()];
                int i=0;
                for(int j:x)z[i++]=j;
                for(int j=0;j<p;j++)sb.append(z[j]+" ");
                sb.append("\n");
                for(int j=p;j<x.size();j++)sb.append(1+" "+z[j]+"\n");
            }
            System.out.println(sb);
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
