import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("#.000000");
        StringTokenizer str;
        int n=Integer.parseInt(br.readLine());
        Integer[] a=new Integer[n];
        long[] b=new long[n+1];
        b[0]=0;
        long[] c=new long[n+1];
        c[0]=0;
        str=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(str.nextToken());
            b[i+1]=a[i]+b[i];
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            c[i+1]=a[i]+c[i];
        }
        int l,r;
 
        int m=Integer.parseInt(br.readLine());
        while(m-->0){
            str=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(str.nextToken());
            if(t==1){
                l=Integer.parseInt(str.nextToken());
                r=Integer.parseInt(str.nextToken());
                System.out.println(b[r]-b[l-1]);
            }
            else{
                l=Integer.parseInt(str.nextToken());
                r=Integer.parseInt(str.nextToken());
                System.out.println(c[r]-c[l-1]);
            }
        }
    }
}
