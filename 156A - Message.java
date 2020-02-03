import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next(),u=sc.next();
        int max=0;
        for(int i=0;i<s.length();i++){
            int cnt=0;
            for(int j=0;j<u.length() && i+j<s.length();j++){
                if(s.charAt(i+j)==u.charAt(j))cnt++;
            }
            max=Math.max(max,cnt);
        }

        for(int i=0;i<u.length();i++){
            int cnt=0;
            for(int j=0;j<s.length() && i+j<u.length();j++){
                if(u.charAt(i+j)==s.charAt(j))cnt++;
            }
            max=Math.max(max,cnt);
        }
        System.out.println(u.length()-max);
    }
}
