import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int t=0;
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int index=0;
        for(int i=31;i>=0;i--){
            int occur=0;
            for(int j=0;j<n;j++){
                if((arr[j]&(1<<i))>=1){
                    index=j;
                    occur++;
                }
            }
            if(occur==1)break;
        }
        int temp=arr[index];
        arr[index]=arr[0];
        arr[0]=temp;
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
    }
}
