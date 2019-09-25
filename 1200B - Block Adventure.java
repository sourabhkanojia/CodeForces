import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class problems {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            boolean x = true;
            int r;
            for (int i = 0; i < n - 1; i++) {
                r = Integer.max(0, a[i + 1] - k);
                m += a[i] - r;
                if (m < 0) {
                    x = false;
                    break;
                }
            }
            if (x) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

