import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int sum=0;
            while(c>=2 && b>=1){
                sum+=3;
                c=c-2;
                b=b-1;
            }
            while(b>=2 && a>=1){
                sum+=3;
                b=b-2;
                a=a-1;
            }
            System.out.println(sum);
        }
    }
}
