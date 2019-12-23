import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Candidate {
    static int count=0;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Double[] ll=new Double[n];
        for(int i=0;i<n;i++){
            int x=sc.nextInt(),y=sc.nextInt();
            double a=Math.toDegrees(Math.atan2(y,x));
            if(a<0)a+=360;
            ll[i]=a;
        }
        Arrays.sort(ll);
        double max=360-(ll[n-1]-ll[0]);
        for(int i=0;i<n-1;i++){
            max=Math.max(max,ll[i+1]-ll[i]);
        }
        System.out.println(360-max);
    }
