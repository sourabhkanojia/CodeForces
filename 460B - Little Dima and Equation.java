import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        long temp;
        int count=0;
        for(int i=1;i<=81;i++){
            temp=b*(long)Math.pow(i,a)+c;
            if(temp<1e9  && temp>0 && sum(temp,i)){
                count++;
                sb.append(temp+" ");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
    public static boolean sum(long x,int i){
        long sum = 0;
        for (sum = 0; x > 0; sum += x % 10,x/= 10);
        return sum==i;
    }
}
