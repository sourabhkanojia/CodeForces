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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int temp=0,sum=0,zero=0;
            for(int i=0;i<n;i++){
                temp=sc.nextInt();
                sum+=temp;
                if(temp==0)zero++;
            }
            if(zero>0) System.out.println(sum+zero==0?zero+1:zero);
            else System.out.println(sum==0?1:0);
        }
    }
}
