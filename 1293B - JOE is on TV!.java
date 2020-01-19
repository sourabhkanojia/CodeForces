import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double sum=0;
        while(n>0){
            sum=sum+1/(double)n;
            n--;
        }
        System.out.println(sum);
    }
}
