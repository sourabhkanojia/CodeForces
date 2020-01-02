import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanne sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int x=sc.nextInt(),y=sc.nextInt();
        long l=1,r=(long)1e10;
        long ans=-1;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(a<=mid-mid/x && b<=mid-mid/y && a+b<=mid-mid/(x*y)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
 
        }
        System.out.println(ans);
    }
}
