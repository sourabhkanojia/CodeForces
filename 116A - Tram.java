import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        int min=0;
        int count=0;
        for(int i=0;i<n;i++){
            count=count-a[i];
            count=count+b[i];
            if(count>min)min=count;
        }
        System.out.println(min);
    }
}
