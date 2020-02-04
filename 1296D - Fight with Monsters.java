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
        int n=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt(),k=sc.nextInt();
        int hp[]=new int[n];
        for (int i=0;i<n;i++)hp[i]=sc.nextInt();
        int arr[]=new int[n];
        int z=a+b;
        for (int i=0;i<n;i++){
            int x=hp[i];
            if (x<=a)arr[i]=0;
            else {
                if (x % z == 0)arr[i] = (int) Math.ceil((double) b / a);
                else {
                    int rem = x % z;
                    arr[i] = (int) Math.ceil((double) rem / a)-1;
                }
            }
        }
        Arrays.sort(arr);
        int ans=0;
        for (int i=0;i<n;i++){
            if (k-arr[i]<0)break;
            k=k-arr[i];
            ans++;
        }
        System.out.println(ans);
    }
}
