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
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            int odd=0;
            for(int i=0;i<n;i++){
                if((arr[i]&1)==1)odd++;
            }
            if(odd>0){
                if(odd==n && n%2==0)sb.append("NO");
                else sb.append("YES");
            }
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
}
