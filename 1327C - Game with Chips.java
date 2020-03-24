import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        Point[] chips=new Point[k];
        for(int i=0;i<k;i++)chips[i]=new Point(sc.nextInt(),sc.nextInt());
        Point[] p=new Point[k];
        for(int i=0;i<k;i++)p[i]=new Point(sc.nextInt(),sc.nextInt());
        int x=0,y=0;
        for(int i=0;i<k;i++){
            x=Math.max(x,chips[i].x);
            y=Math.max(y,chips[i].y);
        }
        for(int i=1;i<x;i++)sb.append('U');
        for(int i=1;i<y;i++)sb.append('L');
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x==o2.x)return o1.y-o2.y;
                else return o1.x-o2.x;
            }
        });
        int curx=1,cury=1;
        int max=1;
        for(int i=0;i<k;i++){
            if(curx==p[i].x){
                for(int j=cury;j<p[i].y;j++)sb.append('R');
                cury=p[i].y;
            }
            else{
                for(int j=cury;j>1;j--)sb.append('L');
                cury=1;
                for(int j=curx;j<p[i].x;j++)sb.append('D');
                curx=p[i].x;
                for(int j=1;j<p[i].y;j++)sb.append('R');
                cury=p[i].y;
            }
        }
        System.out.println(sb.length());
        System.out.println(sb);
    }
}
