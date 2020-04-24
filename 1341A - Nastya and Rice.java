import java.awt.*;
import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
 
            if ((a-b)*n<=c+d && (a+b)*n>=c-d)sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
