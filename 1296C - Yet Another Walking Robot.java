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
            boolean z=false;
            int n=sc.nextInt();
            String s=sc.next();
            int x=0,y=0;
            HashMap<Point,Integer> hm=new HashMap<>();
            int l=1,r=s.length();
            for(int i=0;i<s.length();i++){
                hm.put(new Point(x,y),i);
 
                if(s.charAt(i)=='L')x=x-1;
                else if(s.charAt(i)=='R')x=x+1;
                else if(s.charAt(i)=='U')y=y+1;
                else if(s.charAt(i)=='D')y=y-1;
 
                if(hm.containsKey(new Point(x,y))){
                    z=true;
                    int temp=hm.get(new Point(x,y));
                    if(i-temp<=(r-l)){
                        l=temp;
                        r=i;
                    }
                }
            }
            if(!z)sb.append("-1\n");
            else sb.append((l+1)+" "+(r+1)+"\n");
        }
        System.out.println(sb);
    }
}
