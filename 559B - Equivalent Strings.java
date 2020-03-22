import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static HashSet<String> hs=new HashSet<>();
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String a=sc.next(),b=sc.next();
        if(check(a,b)) System.out.println("YES");
        else System.out.println("NO");
    }
    static boolean check(String a,String b){
        if(hs.contains(a+b))return true;
        if(a.length()==1 && b.length()==1){
            if(a.charAt(0)==b.charAt(0))return true;
            else return false;
        }
        if(a.length()!=b.length())return false;
        if(a.equals(b))return true;
        if(a.length()%2==1)return false;
        String a1=a.substring(0,a.length()/2),a2=a.substring(a.length()/2,a.length());
        String b1=b.substring(0,b.length()/2),b2=b.substring(b.length()/2,b.length());
        boolean z=((check(a1,b1) && check(a2,b2)) || (check(a1,b2) && check(a2,b1)));
        if(z)hs.add(a+b);
        return z;
    }
}
