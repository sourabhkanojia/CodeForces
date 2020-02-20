import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),d=sc.nextInt();
            int max=0;
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<n;i++){
                int temp=sc.nextInt();
                hs.add(temp);
                max=Math.max(max,temp);
            }
            if(hs.contains(d)) System.out.println(1);
            else System.out.println(Math.max(2,d%max==0?d/max:d/max + 1));
        }
    }
}
