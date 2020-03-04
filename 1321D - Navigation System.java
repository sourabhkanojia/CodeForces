import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static HashSet<Integer> hs[];
    static int k,min=0,max=0;
    static int p[];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        LinkedList<Integer>[] ll=new LinkedList[n];
        for (int i=0;i<n;i++)ll[i]=new LinkedList<>();
        for (int i=0;i<m;i++){
            int u=sc.nextInt()-1,v=sc.nextInt()-1;
            ll[v].add(u);
        }
        k=sc.nextInt();
        p=new int[k];
        for (int i=0;i<k;i++)p[i]=sc.nextInt()-1;
        LinkedList<Integer> q=new LinkedList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,-1);
        dist[p[k-1]]=0;
        q.add(p[k-1]);
        hs =new HashSet[n];
        for (int i=0;i<n;i++) hs[i]=new HashSet<>();
        while (!q.isEmpty()){
            int v=q.pop();
            for (int u:ll[v]){
                if (dist[u]==-1){
                    q.add(u);
                    dist[u]=dist[v]+1;
                    hs[u].add(v);
                }else if (dist[u]==dist[v]+1) hs[u].add(v);
            }
        }
        dfs(0);
        System.out.println(min+" "+max);
    }
    static void dfs(int i){
        if (i==k-1)return;
        if (hs[p[i]].size()==1){
            if (!hs[p[i]].contains(p[i+1])){
                max++;
                min++;
            }
        }else {
            if (!hs[p[i]].contains(p[i+1])){
                max++;
                min++;
            }else max++;
        }
        dfs(i+1);
    }
}
