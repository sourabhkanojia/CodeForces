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
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] a=new int[200002];
        Set<Integer> hs=new HashSet<>();

        int x=1,y=1;

        for(int i=0;i<n;i++){
            int z=sc.nextInt();
            if(hs.contains(z))continue;;
            if(y-x<k){
                a[y++]=z;
                hs.add(z);
            }
            else{
                hs.remove(a[x++]);
                a[y++]=z;
                hs.add(z);
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(hs.size()+"\n");
        for(int i=y-1;i>=x;i--) sb.append(a[i]+" ");
        System.out.println(sb);
    }
}
