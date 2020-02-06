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
        StringBuilder sb=new StringBuilder(sc.next());
        int[] arr=new int[26];
        for(int i=0;i<sb.length();i++)arr[sb.charAt(i)-'a']++;
        int k=sc.nextInt(),count=0;
        while(k-->0){
            String z=sc.next();
            int a=0,b=0;
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)==z.charAt(0)){
                    a++;continue;
                }
                else if(sb.charAt(i)==z.charAt(1)){
                    b++;continue;
                }
                count+=Math.min(a,b);
                a=0;b=0;
            }
            count+=Math.min(a,b);
            a=0;b=0;
        }
        System.out.println(count);
    }
}
