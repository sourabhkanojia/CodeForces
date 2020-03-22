import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static HashSet<Integer>[] hr,hb;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),x=sc.nextInt();
            int max=Integer.MIN_VALUE;
            int dmax=-1;
            for(int i=0;i<n;i++){
                int d=sc.nextInt(),h=sc.nextInt();
                if(d-h>max){
                    max=d-h;
                }
                if(d>dmax)dmax=d;
            }
            if(max<=0 && x-dmax>0) sb.append(-1+"\n");
            else{
                x=x-dmax;
                sb.append((int)Math.ceil(x<=0?0:x/(double)max)+1+"\n");
            }
        }
        System.out.println(sb);
    }
}
