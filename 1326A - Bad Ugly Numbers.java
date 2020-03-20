import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            if(n==1)sb.append(-1);
            else{
                sb.append(2);
                n--;
                while(n-->0)sb.append(3);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
