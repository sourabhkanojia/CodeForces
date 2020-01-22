import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(Sytem.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Point[] p=new Point[n];
            for(int i=0;i<n;i++){
                p[i]=new Point(sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(p, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.x==o2.x){
                        return o1.y-o2.y;
                    }
                    else return o1.x-o2.x;
                }
            });
            StringBuilder sb=new StringBuilder();
            int count=0;
            Point start=new Point(0,0);
            boolean z=true;
            for(int i=0;i<n;i++){
                int x=p[i].x;
                int y=p[i].y;
                if(x<start.x || y<start.y){
                    z=false;
                    break;
                }
                for(int j=start.x;j<x;j++){
                    sb.append('R');
                    start.x++;
                }
                for(int j=start.y;j<y;j++){
                    sb.append('U');
                    start.y++;
                }
            }
            if(z){
                System.out.println("YES");
                System.out.println(sb);
            }
            else System.out.println("NO");
        }
    }
}
