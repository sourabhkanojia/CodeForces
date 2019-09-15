import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import static java.lang.Integer.parseInt;
 
public class Main {
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("#.000000");
        StringTokenizer str;
        int n = parseInt(br.readLine());
        int[] a = new int[n];
        str = new StringTokenizer(br.readLine());
 
        int rest=0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str.nextToken());
            if(a[i]==0)rest++;
        }
 
 
        int temp=0;
 
        for(int i=0;i<n;i++){
 
            if(temp==0 &&(a[i]==1 || a[i]==2)){
                temp=a[i];
                continue;
            }
            if(a[i]==0){
                temp=0;
            }
            if(temp==1 &&(a[i]==2 || a[i]==3)){
                temp=2;
                continue;
            }
            if(temp==2 &&(a[i]==1 || a[i]==3)){
                temp=1;
                continue;
            }
            if(temp==a[i] && temp!=0){
                rest++;
                temp=0;
            }
 
        }
        System.out.println(rest);
 
    }
}
