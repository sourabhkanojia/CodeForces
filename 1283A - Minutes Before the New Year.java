import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int h=sc.nextInt();
            int m=sc.nextInt();
            int c=(23-h)*60+(60-m);
            System.out.println(c);
        }
    }
}
