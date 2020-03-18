import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long n=sc.nextLong();
        if(n==1) System.out.println(1);
        else if(n==2) System.out.println(2);
        else if(n==3) System.out.println(6);
        else if((n&1)==1) System.out.println(n*(n-1)*(n-2));
        else if(n%3!=0) System.out.println(n*(n-1)*(n-3));
        else System.out.println((n-1)*(n-2)*(n-3));
    }
}
