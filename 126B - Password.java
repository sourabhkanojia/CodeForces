import javax.print.attribute.standard.PrintQuality;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[] z=zFunction(s);
        int max=0;
        for(int i=1;i<z.length;i++){
            if(z[i]==z.length-i && max>=z[i]){
                System.out.println(s.substring(0,z[i]));
                return;
            }
            max=Math.max(max,z[i]);
        }
        System.out.println("Just a legend");
    }
    static int[] zFunction(String s){
        int n=s.length();
        int[] z=new int[n];
        for(int i=1,l=0,r=0;i<n;i++){
            if(i<=r)z[i]=Math.min(r-i+1,z[i-l]);
            while(z[i]+i<n && s.charAt(z[i])==s.charAt(i+z[i]))z[i]++;
            if(i+z[i]-1>r){
                r=i+z[i]-1;
                l=i;
            }
        }
        return z;
    }
}
