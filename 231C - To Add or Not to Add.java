import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int k=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        long[] sum=new long[n+1];
        int max=1,sol=arr[0];
        for(int i=1;i<=n;i++)sum[i]=sum[i-1]+arr[i-1];
        for(int i=2;i<=n;i++){
            int l=1,r=i;
            int ans=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                long x=sum[i]-sum[mid-1];
                if((long)(i-(mid-1))*arr[i-1]-x<=k){
                    r=mid-1;
                    ans=mid;
                }
                else l=mid+1;
            }
            if(ans!=-1 && max<i-(ans-1)){
                max=i-(ans-1);
                sol=arr[i-1];
            }
        }
        System.out.println(max+" "+sol);
    }
}
class Edge implements Comparable<Edge>{
    int v,weight;
    public Edge(int v,int weight){
        this.v=v;
        this.weight=weight;
    }
    public int compareTo(Edge o){
        return this.weight-o.weight;
    }
}
class Graph{
    int v;
    LinkedList<Edge>[] ll;
    public Graph(int v){
        this.v=v;
        ll=new LinkedList[v];
        for(int i=0;i<v;i++)ll[i]=new LinkedList();
    }
    public void addEdge(int u,int v,int weight){
        ll[u].add(new Edge(v,weight));
        ll[v].add(new Edge(u,weight));
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
