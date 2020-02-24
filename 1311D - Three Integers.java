import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
            int aa=0, bb=0, cc=0, ans = Integer.MAX_VALUE;
            for (int i = 1; i <= c; i++) {
                int curA = i, curB = 0, curC = 0;
                for (int j = 1; j * i <= 2 * b; j++) {
                    curB = j * i;
                    for (int k = 1; k * curB <= 2 * c; k++) {
                        curC = k * curB;
                        int tmp = Math.abs(a - curA) + Math.abs(b - curB) + Math.abs(c - curC);
                        if (tmp < ans) {
                            ans = tmp;
                            aa = curA; bb = curB; cc = curC;
                        }
                    }
                }
            }
            System.out.println(ans);
            System.out.println(aa+" "+bb+" "+cc);
        }
    }
}
