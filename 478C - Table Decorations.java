import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanne sc=new Scanner(System.in);
        long[] arr=new long[3];
        for(int i=0;i<3;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        if(arr[2]/2>=arr[1]+arr[0]) System.out.println(arr[1]+arr[0]);
        else System.out.println((arr[0]+arr[1]+arr[2])/3);
    }
}
