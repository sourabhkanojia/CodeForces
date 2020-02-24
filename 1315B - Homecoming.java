import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt(),b=sc.nextInt(),p=sc.nextInt();
            String s=sc.next();
            int one=s.length()-1;
            for(int i=s.length()-2;i>=0;i--){
                if(i>0 && s.charAt(i)!=s.charAt(i-1)){
                    if(s.charAt(i)=='B'){
                        if(p<b)break;
                        one=i;
                        p=p-b;
                    }
                    else{
                        if(p<a)break;
                        one=i;
                        p=p-a;
                    }
                }
                if(i==0){
                    if(s.charAt(i)=='B'){
                        if(p>=b)one=0;
                    }
                    else{
                        if(p>=a)one=0;
                    }
                }
            }
            System.out.println(one+1);
        }
    }
}
