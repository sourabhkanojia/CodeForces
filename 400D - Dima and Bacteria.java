import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static int[] par,size;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int[] type=new int[n+1];
        int count=0;  int[] c=new int[k];
        for(int i=0;i<k;i++){
            c[i]=sc.nextInt();
            for(int j=count+1;j<=count+c[i];j++)type[j]=i;
            count+=c[i];
        }
        int[][] arr=new int[k][k];
        par=new int[n+1]; size=new int[n+1];
        for(int i=1;i<=n;i++)par[i]=i;
        for(int[] i:arr)Arrays.fill(i,-1);
        for(int i=0;i<m;i++){
            int u=sc.nextInt(),v=sc.nextInt(),x=sc.nextInt();
            if(x==0)union(u,v);
            if(arr[type[u]][type[v]]==-1){
                arr[type[u]][type[v]]=x;
                arr[type[v]][type[u]]=x;
            }
            else{
                arr[type[u]][type[v]]=Math.min(x,arr[type[u]][type[v]]);
                arr[type[v]][type[u]]=Math.min(x,arr[type[u]][type[v]]);
            }
        }
        count=0;
        for(int i=0;i<k;i++){
            int x=c[i];
            int temp=find(count+1);
            for(int j=count+1;j<=count+x;j++){
                if(find(j)!=temp){
                    System.out.println("No");
                    return;
                }
            }
            count+=x;
        }
        for(int j=0;j<k;j++){
            if(c[j]==1){
                arr[j][j]=0;
            }
        }
        for (int p=0;p<k;p++){
            for (int q=0;q<k;q++){
                for (int j=0;j<k;j++){
                    if ((arr[q][p]!=-1 && arr[p][j]!=-1)) {
                        if (arr[q][j] == -1) {
                            arr[q][j] = arr[q][p]+arr[p][j];
                        }else arr[q][j]=Math.min(arr[q][p]+arr[p][j],arr[q][j]);
                    }
                }
            }
        }
        sb.append("Yes\n");
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++)sb.append(arr[i][j]+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int find(int v){
        if(par[v]==v)return v;
        else return par[v]=find(par[v]);
    }
    static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]<size[b]){
                par[a]=b;
                size[b]+=size[a];
            }
            else{
                par[b]=a;
                size[a]+=size[b];
            }
        }
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
