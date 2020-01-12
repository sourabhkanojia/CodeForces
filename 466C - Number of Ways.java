import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] sum=new long[n];

        for(int i=0;i<n;i++){
            if(i==0)sum[i]=sc.nextLong();
            else sum[i]=sum[i-1]+sc.nextLong();
        }
        if(sum[n-1]%3!=0 || n<=2){
            System.out.println(0);
            return;
        }
        long mid=sum[n-1]/3;
        LinkedList<Integer> ll=new LinkedList<>();
        for(int i=0;i<n-2;i++)if(sum[i]==mid)ll.add(i);
        ArrayList<Integer> arr=new ArrayList<>(1000000);
        for(int i=1;i<n-1;i++)if(sum[n-1]-sum[i]==mid)arr.add(i);
        long count=0;
        for(int i:ll){
            int ans=-1;
            int l=0,r=arr.size();
            while(l<=r){
                int m=l+(r-l)/2;
                if(i<arr.get(m)){
                    ans=m;
                    r=m-1;
                }
                else l=m+1;
            }
            count=count+arr.size()-ans;
        }
        System.out.println(count);
    }
}
