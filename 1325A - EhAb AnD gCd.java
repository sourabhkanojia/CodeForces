import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt();
            sb.append(1+" "+(x-1)+"\n");
        }
        System.out.println(sb);
    }
}
