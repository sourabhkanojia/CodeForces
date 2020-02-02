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
        String a = sc.next(), b = sc.next();
        boolean one = a.contains("1"), one2 = b.contains("1");
        if(a.length()!=b.length()){
            System.out.println("NO");
            return;
        }
        if((one && one2) || (!one && !one2)) System.out.println("YES");
        else System.out.println("NO");
    }
}
