import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        long u=sc.nextLong(),v=sc.nextLong(),x=(v-u)/2;
        if(u>v || ((u&1)!=(v&1))){
            System.out.println(-1);
        }
        else if(u==v){
            if(u==0) System.out.println(0);
            else{
                System.out.println(1);
                System.out.println(u);
            }
        }
        else if((u&x)==0){
            System.out.println(2);
            System.out.println(x+" "+(u+x));
        }
        else{
            System.out.println(3);
            System.out.println(x+" "+x+" "+u);
        }
    }
}
