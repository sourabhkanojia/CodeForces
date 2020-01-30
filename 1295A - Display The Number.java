import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            if(n%2==1){
                sb.append('7');
                n=n-3;
            }
            while(n>=2){
                sb.append("1");
                n=n-2;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
