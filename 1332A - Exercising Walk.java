import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
            int x=sc.nextInt(),y=sc.nextInt(),x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt();
            int lr=Math.abs(a-b);
            int ud=Math.abs(c-d);
            boolean LR=false;
            boolean UD=false;
            if(a>b && x-(a-b)>=x1)LR=true;
            else if(b>a && x+(b-a)<=x2)LR=true;
            else if(a==b && (a==0 || x-1>=x1 || x+1<=x2))LR=true;

            if(c>d && y-(c-d)>=y1)UD=true;
            else if(d>c && y+(d-c)<=y2)UD=true;
            else if(d==c && (c==0 || y-1>=y1 || y+1<=y2))UD=true;

            if(LR && UD)sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
