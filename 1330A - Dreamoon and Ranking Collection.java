import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), x = sc.nextInt();
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<n;i++)hs.add(sc.nextInt());
            int i = 1;
            while(x > 0) {
                if(!hs.contains(i)) x--;
                i++;
            }
            while(hs.contains(i)) i++;
            i--;
            sb.append(i+"\n");
        }
        System.out.println(sb);
    }
}
