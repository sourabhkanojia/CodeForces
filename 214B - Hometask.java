import javax.print.attribute.standard.PrintQuality;
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
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        long sum=0;
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        Arrays.sort(arr,Collections.reverseOrder());
        if(arr[0]==0){
            System.out.println(0);
            return;
        }
        if(arr[n-1]!=0){
            System.out.println(-1);
            return;
        }
        sum=sum%3;
        int[] m=new int[n];
        for(int i=0;i<n;i++)m[i]=arr[i]%3;
        boolean z=false;
        if(sum==0)z=true;
        else if(sum==1){
            int j=-1,k=-1;
            for(int i=n-1;i>=0;i--){
                if(m[i]==1){
                    z=true;
                    arr[i]=-1;
                    break;
                }
                if(m[i]==2){
                    if(j==-1)j=i;
                    else k=i;
                }
            }
            if(!z)if(j!=-1 && k!=-1){
                arr[j]=-1;arr[k]=-1;z=true;
            }
        }
        else{
            int j=-1,k=-1;
            for(int i=n-1;i>=0;i--){
                if(m[i]==2){
                    z=true;
                    arr[i]=-1;
                    break;
                }
                if(m[i]==1){
                    if(j==-1)j=i;
                    else k=i;
                }
            }
            if(!z)if(j!=-1 && k!=-1){
                arr[j]=-1;arr[k]=-1;z=true;
            }
        }
        if(z){
            for(int i=0;i<n;i++){
                if(arr[i]!=-1)sb.append(arr[i]);
            }
            if(sb.charAt(0)=='0') System.out.println(0);
            else System.out.println(sb);
        }
        else System.out.println(-1);
    }
}
