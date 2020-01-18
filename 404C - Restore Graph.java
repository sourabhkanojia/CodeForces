import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        ArrayList<Integer>[] dist=new ArrayList[n];
        for(int i=0;i<n;i++)dist[i]=new ArrayList<>();
        for(int i=1;i<=n;i++)dist[sc.nextInt()].add(i);

        if(dist[0].size()!=1){
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> e=new ArrayList<>();
        int[] deg=new int[n+1];
        for(int i=1;i<n;i++){
            for(int j=0;j<dist[i].size();j++){
                if(dist[i-1].size()==0 && dist[i].size()!=0){
                    System.out.println(-1);
                    return;
                }
                int u;
                if(dist[i-1].size()>=dist[i].size()){
                    u=dist[i-1].get(j);
                }
                else u=dist[i-1].get(j%dist[i-1].size());
                if(deg[u]<k && deg[dist[i].get(j)]<k){
                    deg[u]++;
                    deg[dist[i].get(j)]++;
                    e.add(u);
                    e.add(dist[i].get(j));
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(e.size()/2+"\n");
        for(int i=0;i<e.size()-1;i+=2)sb.append(e.get(i)+" "+e.get(i+1)+"\n");
        System.out.println(sb);
    }
}
