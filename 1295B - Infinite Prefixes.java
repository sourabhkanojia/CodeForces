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
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), x = sc.nextInt();
            String s = sc.next();
            int[] zero = new int[n];
            zero[0] = s.charAt(0) == '0' ? 1 : 0;
            for (int i = 1; i < n; i++) {
                zero[i] = zero[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            }
            int[] bal = new int[n];
            for (int i = 0; i < n; i++) {
                bal[i] = zero[i] - (i + 1 - zero[i]);
            }
            if (bal[n - 1] == 0) {
                boolean z = false;
                for (int i = 0; i < n; i++) {
                    if (bal[i] == x) {
                        z = true;
                        break;
                    }
                }
                if (z)sb.append(-1+"\n");
                else sb.append(0+"\n");
            } else {
                int ans = 0, temp;
                for (int i = 0; i < n; i++) {
                    temp = x - bal[i];
                    if(temp%bal[n-1]==0 && temp/bal[n-1]>=0)ans++;
                }
                if(x==0)ans++;
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb);
    }
}
