import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    static double[][] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(Sysetem.in);
        int w=sc.nextInt(),b=sc.nextInt();
        dp=new double[w+1][b+1];
        for(double[] i:dp)Arrays.fill(i,-1);
        int i=1;
        System.out.println(cal(w,b));
    }
    static double cal(int w,int b){
        if(w<=0)return 0;
        if(b<=0)return 1;

        if(dp[w][b]!=-1)return dp[w][b];
        double res=(double)w/(w+b), cp=(double)b/(w+b);
        b--;
        cp*=(double)b/(w+b);
        b--;
        if(cp>1e-10){
            double b_mice=cal(w,b-1)*(double)b/(w+b);
            double w_mice=cal(w-1,b)*(double)w/(w+b);
            res+=cp*(b_mice+w_mice);
        }
        b++;
        b++;
        return dp[w][b]=res;
    }
}
