import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),n=sc.nextInt();
            double x=(n+a+b+c)/3.0;
            if(x>(int)x) System.out.println("NO");
            else {
                if(x>=Math.max(a,Math.max(b,c)))System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
