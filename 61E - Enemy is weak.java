import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int[] bit;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        int[] temp=arr.clone();
        Arrays.sort(temp);
        for(int i=0;i<n;i++)arr[i]=Arrays.binarySearch(temp,arr[i])+1;
        long result=0;
        bit=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int smaller=sum(arr[i]);
            int greater=i-(arr[i]-smaller-1);
            result+=(long)smaller*greater;
            update(arr[i]);
        }
        System.out.println(result);
    }
    static int sum(int i){
        int res=0;
        while(i>0){
            res+=bit[i];
            i-=(i&-i);
        }
        return res;
    }
    static void update(int i){
        while(i<bit.length){
            bit[i]++;
            i+=(i&-i);
        }
    }
}
