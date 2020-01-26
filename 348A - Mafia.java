import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double max=0,sum=0;
        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            max=Math.max(max,temp);
            sum+=temp;
        }
        System.out.println((int)Math.ceil(Math.max(max,sum/(n-1))));
    }
}
