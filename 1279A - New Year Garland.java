import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int[] arr=new int[3];
            for(int i=0;i<3;i++)arr[i]=sc.nextInt();
            Arrays.sort(arr);
            if(arr[0]+arr[1]<arr[2]-1) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
