import java.awt.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int ans=0;
        for(int i=6;i<=n;i++){
            int temp=i;
            int count=0;
            for(int j=2;j*j<=temp;j++){
                if(temp%j==0){
                    count++;
                    while(temp%j==0)temp/=j;
                }
            }
            if(temp>1)count++;
            if(count==2)ans++;
        }
        System.out.println(ans);
    }
}
