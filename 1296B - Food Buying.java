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
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sol=0;
            while(n>0){
                int temp=n/10;
                temp=temp*10;
                if(temp==0){
                    sol+=n;
                    break;
                }
                n=n-temp;
                sol+=temp;
                n=n+(temp/10);
            }
            sb.append(sol+"\n");
        }
        System.out.println(sb);
    }
}
