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
        Scanner sc=new Scanner(Sytem.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while(t-->0){
            String a=sc.nextLine(),b=sc.nextLine(),c=sc.nextLine();
            boolean z=false;
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)==c.charAt(i) || b.charAt(i)==c.charAt(i))continue;
                else{
                    z=true;
                    break;
                }
            }
            if(z)sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
