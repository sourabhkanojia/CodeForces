import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),r=sc.nextInt(),l=c-r;
            r=c+r;
            if(b<a){
                int temp=b;
                b=a;
                a=temp;
            }
            if(l<=a){
                int z=Integer.max(a,r);
                System.out.println((b-z)>=0?(b-z):0);
            }
            else{
                int z=Integer.min(b,l);
                System.out.println(z-a+(b-r>=0?b-r:0));
            }

        }
    }
}
