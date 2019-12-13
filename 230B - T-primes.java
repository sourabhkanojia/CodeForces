import java.awt.dnd.Autoscroll;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, NullPointerException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++)a[i]=sc.nextLong();

        boolean[] p=new boolean[1000001];
        p[0]=false;
        p[1]=false;
        p[2]=true;
        for(int i=3;i<p.length;i+=2)p[i]=true;

        for(int i=3;i<p.length;i+=2){
            if(p[i]){
                for(int j=3*i;j<p.length;j+=2*i)p[j]=false;
            }
        }
        Set<Long> hs=new HashSet<>();
        hs.add(4L);
        for(int i=3;i<p.length;i+=2){
            if(p[i])hs.add((long)i*i);
        }
        for(int i=0;i<n;i++){
            if(hs.contains(a[i])) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
