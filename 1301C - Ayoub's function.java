import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextInt(),m=sc.nextInt();
            long zero=n-m;
            long k=zero/(m+1);
            sb.append((n*(n+1)/2)-((m+1)*k*(k+1)/2)-((k+1)*(zero%(m+1)))+"\n");
        }
        System.out.println(sb);
    }
}
