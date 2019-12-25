import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder s=new StringBuilder(sc.next());
        int a=sc.nextInt();
        int n=s.length();
        if(a>=s.length()) System.out.println(((a+n)/2)*2);
        else{
            for(int i=1;i<=a;i++)s.append("!");
            n=s.length();
            int min=a+1;
            int max=n/2;
            for(int i=min;i<=max;i++){
                for(int j=i;j<=n-i;j++){
                    if(check(s.substring(j-i,j),s.substring(j,j+i))){
                        a=i;
                        break;
                    }
                }
            }
            System.out.println(a*2);
        }
    }
    public static boolean check(String x,String y){
        boolean z=true;
        for(int i=0;i<x.length();i++){
            if(y.charAt(i)!='!' && x.charAt(i)!=y.charAt(i)){
                z=false;
                break;
            }
        }
        return z;
    }
}
