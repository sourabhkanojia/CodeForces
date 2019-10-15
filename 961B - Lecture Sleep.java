import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int[] b=new int[n];
        for(int i=0;i<n;i++)b[i]=sc.nextInt();

        long slid=0;
        long sum=0;

        for(int i=0;i<n;i++){
            if(b[i]==1)sum=sum+a[i];
        }

        for(int i=0;i<k;i++){
            if(b[i]==0)slid+=a[i];
        }

        long dp=slid;
        for(int i=0;i<n-k;i++){
            if(b[i]==0)slid-=a[i];
            if(b[i+k]==0)slid+=a[i+k];

            if(slid>dp)dp=slid;
        }
        System.out.println(sum+dp);
    }
}
