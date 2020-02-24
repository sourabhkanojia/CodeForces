
import java.awt.Point;
import java.io.*;
import java.util.*;
 
 public class Main {
    static int z=0;
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            long a=sc.nextInt(),b=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
            long ans=Math.max(b*x,Math.max(y*a,Math.max((a-x-1)*b,(b-y-1)*a)));
            System.out.println(ans);
        }
    }
}
