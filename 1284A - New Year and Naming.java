 import java.io.*;
 import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n=sc.nextInt(),m=sc.nextInt();
        String[] str=new String[n+1];
        String[] str2=new String[m+1];
        for(int i=1;i<=n;i++)str[i]=sc.next();
        for(int i=1;i<=m;i++)str2[i]=sc.next();
        int q=sc.nextInt();
        while(q-->0){
            int y=sc.nextInt();
            int a=y%n;
            int b=y%m;
            if(a==0)a=n;
            if(b==0)b=m;
            System.out.println(str[a]+""+str2[b]);
        }
    }
}
