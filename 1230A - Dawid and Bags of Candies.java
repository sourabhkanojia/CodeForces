import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
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
 
 
 
public class candidate {
 
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int[] a=new int[4];
        for(int i=0;i<4;i++)a[i]=sc.nextInt();
        Arrays.sort(a);
        int x=0;
        int y=0;
 
        x=x+a[3];
        y=y+a[2]+a[1];
        if(x+a[0]==y){
            System.out.println("YES");
            return;
        }
        if(y+a[0]==x){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
 
    }
}
