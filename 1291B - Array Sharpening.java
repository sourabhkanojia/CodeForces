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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            if(n==2){
                if(arr[0]==0 && arr[1]==0)sb.append("NO\n");
                else sb.append("YES\n");
                continue;
            }
            arr[0]=0;
            arr[n-1]=0;
            boolean z=false;
            for(int i=1;i<n-1;i++){
                if(arr[i]==0){
                    z=true;
                    break;
                }
            }
            if(z){
                sb.append("NO\n");
                continue;
            }
            int i=1,j=n-2,count=1;
            while(i<=j){
                if(arr[i]>=count);
                else{
                    z=true;
                    break;
                }
                i++;
                if(arr[j]>=count);
                else{
                    z=true;
                    break;
                }
                j--;
                count++;
            }
            if(n%2==0){
                i--;j++;count--;
                if(arr[i]==arr[j]){
                    if(arr[i]==count && arr[j]==count)z=true;
                }
            }
            if(z)sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
