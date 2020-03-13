import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while (t-->0){
            String s=sc.next();
            int ans=0,z=0;
            for (int i=0;i<s.length();i++){
                if (s.charAt(i)=='L')z++;
                else z=0;
                
                ans=Math.max(z,ans);
            }
            sb.append(ans+1+"\n");
        }
        System.out.println(sb);
    }
}
