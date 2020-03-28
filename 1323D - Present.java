import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] pow=new int[26];
        for(int i=0;i<26;i++)pow[i]=1<<i;
        Arrays.sort(arr);
        int ans=0;
        for(int i=1;i<=25;i++){
            int[] b=new int[n];
            for(int j=0;j<n;j++){
                b[j]=arr[j]%pow[i];
            }
            Arrays.sort(b);
            int count=0;
            for(int j=0;j<n;j++){
                int l=lower(b,0,j-1,pow[i-1]-b[j]),r=upper(b,0,j-1,pow[i]-b[j]-1);
                if(l!=-1 && r!=-1){
                    count+=r-l+1;
                }
                int temp=lower(b,j+1,n-1,pow[i-1]+pow[i]-b[j]);
                if(temp!=-1)count+=n-temp;
            }
            if((count&1)==1){
                ans+=pow[i-1];
            }
        }
        System.out.println(ans);
    }
    static int lower(int[] arr,int l,int r,int val){
        int ans=-1;
        while(l<=r){
            int mid=(l+r)>>1;
            if(arr[mid]>=val){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    static int upper(int arr[],int l,int r,int val){
        int ans=-1;
        while (l<=r){
            int mid=(l+r)>>1;
            if (arr[mid]<=val){
                ans=mid;
                l=mid+1;
            }else r=mid-1;
        }
        return ans;
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
