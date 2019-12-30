import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) throws Exception {                  //Simply find the leftmost difference in bit representation
        Scanner sc=new Scanner(System.in);                                     //of the two numbers. If the difference is at the nth bit 
        long a=sc.nextLong(),b=sc.nextLong();                                  //the answer is 2^n — 1.
        int[] l=new int[100];
        int[] r=new int[100];
        int x=0;
        while(a!=0){
            if((a&1)==1)l[x++]=1;
            else x++;
            a>>=1;
        }
        int len=x;
        x=0;
        while(b!=0){
            if((b&1)==1)r[x++]=1;
            else x++;
            b>>=1;
        }
        int i=x-1;
        for(;i>=0;i--){
            if(l[i]!=r[i])break;
        }
        long ans=1;
        while(i>=0){
            ans=ans*2;
            i--;
        }
        System.out.println(ans-1);
    }
}
