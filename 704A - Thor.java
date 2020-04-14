import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        ArrayList<Integer> arr=new ArrayList<>(500000);
        int n=sc.nextInt(),q=sc.nextInt();
        int curr=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        HashMap<Integer,Integer> type2=new HashMap<>();
        int count=0;
        int num=1;
        while(q-->0){
            int x=sc.nextInt();
            if(x==1){
                int app=sc.nextInt();
                arr.add(app);
                count++;
                hm.put(app,hm.getOrDefault(app,0)+1);
            }
            else if(x==2){
                int app=sc.nextInt();
                count-=hm.getOrDefault(app,0);
                hm.remove(app);
                type2.put(app,arr.size()-1);
            }
            else{
                int t=sc.nextInt();
                for(int i=curr;i<t;i++){
                    if(hm.containsKey(arr.get(i))) {
                        Integer z=type2.get(arr.get(i));
                        if(z!=null && i<=z)continue;
                        int temp = hm.get(arr.get(i));
                        hm.put(arr.get(i), temp - 1);
                        count--;
                    }
                }
                curr=Math.max(curr,t);
            }
            sb.append(count+"\n");
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
