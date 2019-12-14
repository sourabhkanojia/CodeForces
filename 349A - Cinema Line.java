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
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int[] bills=new int[3];
        for(int i=0;i<n;i++){
            if(arr[i]==25){
                bills[0]++;
            }
            else if(arr[i]==50){
                if(bills[0]>0){
                    bills[0]--;
                    bills[1]++;
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }
            else{
                if(bills[0]>0 && bills[1]>0){
                    bills[0]--;
                    bills[1]--;
                    bills[2]++;
                }
                else if(bills[0]>=3){
                    bills[2]++;
                    bills[0]-=3;
                }
                else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
