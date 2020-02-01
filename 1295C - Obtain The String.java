import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        TreeSet<Integer>[] treeSets=new TreeSet[26];
        int test=sc.nextInt();
        while(test-->0) {
            String s = sc.next(), t = sc.next();
            for (int i = 0; i < 26; i++) treeSets[i] = new TreeSet<>();
            for (int i = 0; i < s.length(); i++) {
                treeSets[s.charAt(i) - 'a'].add(i);
            }
            long count = 0;
            int cur = -1;
            Integer temp;
            char c;
            boolean z=true;
            for (int i = 0; i < t.length(); i++) {
                c = t.charAt(i);
                temp = treeSets[c - 'a'].higher(cur);
                if (temp == null) {
                    cur = -1;
                    temp = treeSets[c - 'a'].higher(cur);
                    if (temp == null) {
                        z=false;
                        break;
                    } else {
                        count++;
                        cur = temp;
                    }
                    if (i == t.length() - 1) count++;
                } else if (temp <= cur) {
                    cur = temp;
                    count++;
                    if (i == t.length() - 1) count++;
                } else {
                    if (i == t.length() - 1) count++;
                    cur = temp;
                }
            }
            if(z)sb.append(count+"\n");
            else sb.append(-1+"\n");
        }
        System.out.println(sb);
    }
}
