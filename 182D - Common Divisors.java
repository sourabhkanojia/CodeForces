import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder(sc.nextLine());
        StringBuilder sb2=new StringBuilder(sc.nextLine());
        int x=sb.length(),y=sb2.length();
        int max=Math.max(x,y);
        HashSet<Integer> hs=new HashSet<>();
        for(int i=1;i*i<=max;i++){
            if(x%i==0 && y%i==0){
                hs.add(i);
                int a=x/i,b=y/i;
                if(y%a==0)hs.add(a);
                if(x%b==0)hs.add(b);
            }
        }
        int count=0;
        for(int i:hs){
            int temp=i;
            boolean z=true;
            String s=sb.substring(0,temp);
            for(int j=temp;j<sb.length();j+=temp){
                if(!s.equals(sb.substring(j,j+temp).toString())){
                    z=false;
                    break;
                }
            }
            if(z){
                for(int j=0;j<sb2.length();j+=temp){
                    if(!s.equals(sb2.substring(j,j+temp).toString())){
                        z=false;
                        break;
                    }
                }
            }
            if(z)count++;
        }
        System.out.println(count);
    }
}
