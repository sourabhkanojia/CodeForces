import java.awt.dnd.Autoscroll;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int pile=0;
        while(true){
            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]!=null){
                    count++;
                    arr[i]=null;
                    break;
                }
            }

            if(count==0)break;
            for(int i=0;i<n;i++){
                if(arr[i]!=null && arr[i]>=count){
                    arr[i]=null;
                    count++;
                }
            }
            pile++;
        }
        System.out.println(pile);
    }
}
