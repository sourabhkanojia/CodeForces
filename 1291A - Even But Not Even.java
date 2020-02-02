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
        while (t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            int od=0;
            String ss="";
            for (int i=0;i<n;i++){
                if ((s.charAt(i)-'0')%2==1){
                    od++;
                    ss+=(s.charAt(i));
                    if (od==2)break;
                }
            }
            if (od==2){
                sb.append(ss+"\n");
            }else sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
