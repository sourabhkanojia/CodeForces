import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            StringBuilder s=new StringBuilder(sc.next());
            String ans=s.toString();
            int ind=1;
            for (int k=2;k<=n;k++){
                if ((n-(k-1))%2==0){
                    String y=s.substring(k-1)+s.substring(0,k-1);
                    if (ans.compareTo(y)>0){
                        ans=y;
                        ind=k;
                    }
                }else {
                    StringBuilder temp=new StringBuilder(s.substring(0,k-1));
                    String y=s.substring(k-1)+temp.reverse();
                    if (ans.compareTo(y)>0){
                        ans=y;
                        ind=k;
                    }
                }
            }
            sb.append(ans+"\n"+ind+"\n");
        }
        System.out.println(sb);
    }
}
