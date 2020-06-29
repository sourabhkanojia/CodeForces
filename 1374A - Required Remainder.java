import java.io.*;
import java.util.*;
import java.awt.*;
 
public class Main{
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt(),y=sc.nextInt(),n=sc.nextInt();
                int z=n%x;
                if(z>y){
                    n-=(z-y);
                    sb.append(n);
                }
                else if(z==y)sb.append(n);
                else{
                    n-=x;
                    n+=(y-z);
                    sb.append(n);
                }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
