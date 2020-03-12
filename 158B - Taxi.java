mport java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[5];
        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            if(temp==1)arr[1]++;
            else if(temp==2)arr[2]++;
            else if(temp==3)arr[3]++;
            else if(temp==4)arr[4]++;
        }
        if(arr[2]%2!=0){
            if(arr[1]>=2){
                arr[2]++;
                arr[1]-=2;
            }
            else if(arr[1]==1){
                arr[1]=0;
            }
        }
        int temp=Math.min(arr[1],arr[3]);
        arr[1]-=temp;
        arr[3]-=temp;
        System.out.println(temp+arr[4]+arr[3]+(int)Math.ceil(arr[2]/2.0)+(int)Math.ceil(arr[1]/4.0));
    }
}
