import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        ArrayList<Integer> arr=new ArrayList<>(200001);
        HashSet<Integer> hs=new HashSet<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            if(!hs.contains(temp)){
                if(temp<0)arr.add(-temp);
                else arr.add(temp);
                hs.add(temp);
            }
        }
        Collections.sort(arr);
        long count=0;
        for(int i=0;i<arr.size();i++){
            int temp=2*arr.get(i),l=i,r=arr.size()-1,ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(arr.get(mid)<=temp){
                    ans=mid;
                    l=mid+1;
                }
                else r=mid-1;
            }
            if(ans!=-1)count+=(ans-i);
        }
        System.out.println(count);
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
