import java.io.*;
import java.util.*;

public class Main {
    static int ind[];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
            ArrayList<Integer> adj[]=new ArrayList[n+1];
            for (int i=0;i<=n;i++)adj[i]=new ArrayList<>();
            for (int i=1;i<=n;i++){
                for (int j=1;j*j<=i;j++){
                    if (i%j==0){
                        adj[i].add(j);
                        if (j!=i/j){
                            adj[i].add(i/j);
                        }
                    }
                }
            }
            int abn=1;
            for (int i=1;i<=n;i++){
                if (!adj[i].isEmpty()){
                    Collections.sort(adj[i]);
                    int arr[]=new int[adj[i].size()];
                    ind=new int[adj[i].size()];
                    for (int j=0;j<adj[i].size();j++){
                        arr[j]=a[adj[i].get(j)];
                        ind[j]=adj[i].get(j);
                    }
                    abn=Math.max(solve(arr,adj[i].size()),abn);
                }
            }
            System.out.println(abn);
        }
    }
    static int solve(int arr[], int n)
    {
        int lis[] = new int[n];
        int x,y,max = 0;
        for ( x = 0; x < n; x++ ) lis[x] = 1;

        for ( x = 1; x < n; x++ )
            for ( y = 0; y < x; y++ )
                if ( arr[x] > arr[y] && lis[x] < lis[y] + 1 && ind[x]%ind[y]==0) lis[x] = lis[y] + 1;

        for ( x = 0; x < n; x++ ) if ( max < lis[x] ) max = lis[x];

        return max;
    }
}
