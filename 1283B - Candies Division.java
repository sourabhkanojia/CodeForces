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
            int n=sc.nextInt();
            int k=sc.nextInt();
            int ans=(n/k);
            int sol=ans*k;
 
            n=n-sol;
            if(n<=Math.floor(k/2))sol+=n;
            else sol+=Math.floor(k/2);
            System.out.println(sol);
        }
    }
}
