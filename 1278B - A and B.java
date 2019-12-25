import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long a=sc.nextInt(),b=sc.nextInt();
            if (a>b){
                long tmp=a;
                a=b;
                b=tmp;
            }
            int sol=0;
            while (a<b || a%2!=b%2){
                sol++;
                a+=sol;
            }
            System.out.println(sol);
        }
    }
}
