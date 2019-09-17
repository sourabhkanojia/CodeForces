import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class problems {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];

        str=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
          a[i]=Integer.parseInt(str.nextToken());
        }
        if(n==1){
            System.out.println(1);
            return;
        }

        int max=-1;
        int count=0;
        for(int i=n-1;i>0;i--){
            if(a[i]-a[i-1]<=a[i-1])count++;
            else count=0;

            if(count>max)max=count;
        }
        System.out.println(max+1); // we compare two elements and count it as one that's why increment by one in the final solution.
    }
}
