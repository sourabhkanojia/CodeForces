import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            long l=sc.nextLong(),r=sc.nextLong();
            while((l|(l+1))<=r){
                l=l|(l+1);
            }
            sb.append(l+"\n");
        }
        System.out.println(sb);
    }
}
