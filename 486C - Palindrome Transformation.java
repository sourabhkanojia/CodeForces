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
        int n=sc.nextInt(),p=sc.nextInt();
        StringBuilder sb=new StringBuilder(sc.nextLine());
        StringBuilder sb2=new StringBuilder(sb.toString());
        sb.replace(0,0," ");
        sb2.reverse();
        sb2.replace(0,0," ");
        int j=n/2;
        if(p>j){
            int temp=n-p;
            p=1+temp;
        }
        int count=0;
        int current=p;
        for(int i=1;i<=j;i++) {
            int diff = Math.abs(sb.charAt(i) - sb2.charAt(i));
            count = count + Math.min(diff, 26 - diff);
        }
        int x=0,y=0;
        for(int i=j;i>p;i--){
            if(sb.charAt(i)!=sb2.charAt(i)){
                y=i-p;
                break;
            }
        }
        for(int i=1;i<p;i++){
            if(sb.charAt(i)!=sb2.charAt(i)){
                x=p-i;
                break;
            }
        }
        count=count+Math.min(x+x+y,y+y+x);
        System.out.println(count);
    }
}
