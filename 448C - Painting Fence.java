import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(sol(0,arr.length-1,0));
    }
    public static int sol(int l,int r,int h){
        if(r<l)return 0;
        int min=Integer.MAX_VALUE,mid=0;
        for(int i=l;i<=r;i++){
            if(arr[i]-h<min){
                min=arr[i]-h;
                mid=i;
            }
        }
        h+=min;
        return Math.min(r-l+1,min+sol(l,mid-1,h)+sol(mid+1,r,h));
    }
}
