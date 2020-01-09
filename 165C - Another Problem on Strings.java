import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.nextLine();
        int n = s.length();
        int[] sum = new int[n];
        if (s.charAt(0) == '0') sum[0] = 0;
        else sum[0] = 1;
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + (s.charAt(i) - '0');
        }
        long ans = 0;
        int[] count = new int[n + 1];
        count[0] = 1;
        for (int i = 0; i < n; i++) {
            int temp = sum[i] - k;
            if (temp >= 0) ans += count[temp];
            count[sum[i]]++;
        }
        System.out.println(ans);
    }
}
