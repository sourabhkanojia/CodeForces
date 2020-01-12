mport java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        int l=0,r=m;
        int count=0;
        while(l<=n && r>=0){
            sb.append(l+" "+r+"\n");
            count++;
            r--;l++;
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
