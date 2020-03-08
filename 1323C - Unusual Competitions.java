import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] c=sc.next().toCharArray();
        int count=0;
        for(int i=0;i<n;i++){
            if(c[i]=='(')count++;
            else count--;
        }
        if(count!=0){
            System.out.println(-1);
            return;
        }
        int min=0,temp=0,ans=0;
        for(int i=0;i<n;i++){
            if(c[i]==')'){
                if(min>0)min--;
                else{
                    min--;
                    temp++;
                }
            }
            else{
                if(min>=0)min++;
                else{
                    min++;
                    temp++;
                }
            }
            if(min==0){
                ans+=temp;
                temp=0;
            }
        }
        System.out.println(ans);
    }
}
