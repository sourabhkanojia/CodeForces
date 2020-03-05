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
        int n=sc.nextInt(),m=sc.nextInt(),p=sc.nextInt();
        int temp,x=-1,y=-1;

        for(int i=0;i<n;i++){
            temp=sc.nextInt();
            if(temp%p!=0)x=i;
        }

        for(int i=0;i<m;i++){
            temp=sc.nextInt();
            if(temp%p!=0)y=i;
        }
        System.out.println(x+y);
    }
}
