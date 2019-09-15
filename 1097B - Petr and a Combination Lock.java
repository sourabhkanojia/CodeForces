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
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
 
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
 
        int x=1<<n;
        x--;
 
        int count=0;
        for(int i=0;i<=x;i++){
            int z=i;
            for(int j=0;j<n;j++){
                if((z&1)==1)count=count+a[j];
                else count=count-a[j];
                z=z>>1;
 
            }
 
 
            if(count==0 || count%360==0){
                System.out.println("YES");
                return;
            }
            count=0;
        }
        System.out.println("NO");
      }
}
