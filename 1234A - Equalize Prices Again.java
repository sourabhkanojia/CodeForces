import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
 
public class problems {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q-->0){
            int n=sc.nextInt();
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+sc.nextInt();
            }
            if(sum%n==0){
                sum=sum/n;
                System.out.println(sum);
            }
            else System.out.println((sum/n)+1);
        }
    }
}
 
