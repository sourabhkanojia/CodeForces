import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int temp = sc.nextInt();
            int a[] = new int[temp];
            int p[] = new int[temp];
            for (int i = 0; i < temp; i++) {
                a[i] = sc.nextInt() - 1;
                p[a[i]] = i;
            }
            boolean found = true;
            int c = 0;
            for (int i = p[0]; i < temp; i++) {
                if (a[i] != c) {
                    found = false;
                    break;
                }
                c++;
            }
            int f = 0,g = c;
            if (found) {
                while (g < temp) {
                    c = g;
                    int j = p[g];
                    while (j < temp) {
                        if (a[j] != c && a[j] != f) {
                            found = false;
                            break;
                        } else if (a[j] != c) {
                            f = g;
                            break;
                        }
                        c++;
                        j++;
                    }
                    if (!found) break;
                    g = c;
                }
            }
            if (!found) sb.append("NO\n");
            else sb.append("YES\n");
        }
    }
}
