import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt(),k=sc.nextInt();
        Integer[] m=new Integer[n];
        for(int i=0;i<n;i++)m[i]=sc.nextInt();
        Node[] node=new Node[k];
        for(int i=0;i<k;i++)node[i]=new Node(sc.nextInt(),i+1);
        Arrays.sort(m);
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.count==o2.count)return o2.val-o1.val;
                return o1.count -o2.count;
            }
        });
        int max=0;
        for(int i=0;i<k;i++){
            int count=node[i].count,val=node[i].val;
            int l=0,r=n-1,ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(m[mid]>=val){
                    ans=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            if(ans!=-1){
                int total=n-ans;
                max=Math.max(max,total/count+(total%count>0?1:0));
            }
        }
        LinkedList<Integer>[] ll=new LinkedList[max];
        PriorityQueue<LinkedList<Integer>> pq=new PriorityQueue<>(new Comparator<LinkedList<Integer>>() {
            @Override
            public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
                return o1.size()-o2.size();
            }
        });
        int last=n-1;
        for(int i=0;i<max;i++){
            ll[i]=new LinkedList<>();
            pq.add(ll[i]);
        }

        for(int i=0;i<k;i++){
            int count=node[i].count,val=node[i].val;
            int l=0,r=last,ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(m[mid]>=val){
                    ans=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            if(ans!=-1){
                int total=last+1-ans;
                int div=total/count+(total%count>0?1:0);
                while(last>=ans){
                    LinkedList<Integer> temp=pq.remove();
                    temp.add(m[last]);
                    pq.add(temp);
                    last--;
                }
            }
        }
        sb.append(max+"\n");
        for(int i=0;i<max;i++){
            sb.append(ll[i].size()+" ");
            for(int j:ll[i])sb.append(j+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
class Node{
    int count,val;
    public Node(int c,int val){
        this.count =c;
        this.val=val;
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
