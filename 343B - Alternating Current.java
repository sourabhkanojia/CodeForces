import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String s=sc.next();
        if((s.length()&1)==1){
            System.out.println("No");
            return;
        }
        int c1=0,c2=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='-')c1++;
                else c2++;
            }
            else{
                if(s.charAt(i)=='-')c2++;
                else c1++;
            }
        }
        if(c1==c2) System.out.println("Yes");
        else System.out.println("No");
    }
}
