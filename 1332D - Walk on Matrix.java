import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int k=sc.nextInt();
        sb.append("2 3\n");
        sb.append(131072+k+" "+131072+" "+0+"\n");
        sb.append(k+" "+(131072+k)+" "+k);
        System.out.println(sb);

    }
}
