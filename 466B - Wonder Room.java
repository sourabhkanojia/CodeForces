import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong(),a=sc.nextLong(),b=sc.nextLong();
        n=n*6;
        if(n<=a*b) System.out.println(a*b+"\n"+a+" "+b);
        else{
            boolean f=false;
            if(a>b){
                long t=a;
                a=b;
                b=t;
                f=true;
            }
            long temp,a1=0,b1=0,s=(long)1e18;
            for(long i=a;i*i<=n;i++){
                temp=n/i;
                if(temp*i<n)temp++;
                if(temp<b)continue;
                if(temp*i<s){
                    s=temp*i;
                    a1=i;
                    b1=temp;
                }
            }
            System.out.println(a1*b1);
            if(f) System.out.println(b1+" "+a1);
            else System.out.println(a1+" "+b1);
        }
    }
}
