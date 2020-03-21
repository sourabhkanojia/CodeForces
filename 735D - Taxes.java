import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {      //Goldbach's conjecture is used in this problem.
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        if(n%2==0){
            if(n==2) System.out.println(1);
            else System.out.println(2);
        }
        else{
            if(isPrime(n)) System.out.println(1);
            else if(isPrime(n-2)) System.out.println(2);
            else System.out.println(3);
        }
    }
    static boolean isPrime(int n){
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0 || n%(n/i)==0)return false;
        }
        return true;
    }
}
