import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<3) System.out.println(-1);
        else if(n==3) System.out.println(210);
        else{
            BigInteger b1=new BigInteger("10");
            b1=b1.pow(n-1);
            BigInteger b2=b1.mod(new BigInteger("210"));
            b1=b1.add(BigInteger.valueOf(210));
            b1=b1.subtract(b2);
            System.out.println(b1);
        }
    }
}
