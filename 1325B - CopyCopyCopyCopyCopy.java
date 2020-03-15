import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < n; i++) hs.add(sc.nextInt());
            sb.append(hs.size()+"\n");
        }
        System.out.println(sb);
    }
}
