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
        char[] c=sc.nextLine().toCharArray();
        StringBuilder sb=new StringBuilder();
        int m=0;
        for(int i=0;i<c.length;i++){
            if(m>=2 && sb.charAt(m-2)==sb.charAt(m-1) && sb.charAt(m-1)==c[i])continue;
            if(m>=3 && sb.charAt(m-3)==sb.charAt(m-2) && sb.charAt(m-1)==c[i])continue;
            sb.append(c[i]);
            m++;
        }
        System.out.println(sb);
    }
}
