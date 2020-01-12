import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)arr[j][i]=sc.nextInt();
        }
        st[] st=new st[m];
        for(int i=0;i<m;i++)st[i]=new st(arr[i]);
        int max=0;
        int l=0,r=0;
        ArrayList<Integer> ll=new ArrayList<>();
        while(l<=r && r<n){
            int sum=0;
            for(int i=0;i<m;i++){
                sum=sum+st[i].max(l,r);
            }
            if(sum<=k){
                ll=new ArrayList<>(m);
                for(int i=0;i<m;i++)ll.add(st[i].max(l,r));
                r++;
            }
            else{
                l++;r++;
            }
        }
        if(ll.size()==0) for(int i=0;i<m;i++) System.out.print(0+" ");
        else for(int i=0;i<m;i++) System.out.print(ll.get(i)+" ");
    }
}
class st{
    int[] log;
    int[][] sparse;
    int k;
    public st(int[] arr){
        int n=arr.length;
        log=new int[n+1];
        log[1]=0;
        for(int i=2;i<=n;i++)log[i]=log[i/2]+1;
        k=log[n];
        sparse=new int[arr.length][k+1];
        for(int i=0;i<n;i++)sparse[i][0]=arr[i];
        for(int j=1;j<=k;j++){
            for(int i=0;i+(1<<j)<=n;i++){
                sparse[i][j]=Math.max(sparse[i][j-1],sparse[i+(1<<(j-1))][j-1]);
            }
        }
    }
    public int max(int l,int r){
        int j=log[r-l+1];
        return Math.max(sparse[l][j],sparse[r-(1<<j)+1][j]);
    }
}
