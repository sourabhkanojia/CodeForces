import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int dp[][];
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        TreeSet<Integer> treeset=new TreeSet<>();
        int c=Math.min(a,b);
        for(int i=1;i*i<=c;i++){
            if(a%i==0 && b%i==0)treeset.add(i);
            if(a%(c/i)==0 && b%(c/i)==0)treeset.add(c/i);
        }
        int q=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        Integer temp;
        while(q-->0){
            int l=sc.nextInt(),r=sc.nextInt();
            temp=treeset.floor(r);
            if(temp!=null && temp>=l)sb.append(temp+"\n");
            else sb.append("-1\n");
        }
        System.out.println(sb);
    }
}
