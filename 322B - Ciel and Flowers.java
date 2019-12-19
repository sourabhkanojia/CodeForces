import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int[] arr={sc.nextInt(),sc.nextInt(),sc.nextInt()};
        Arrays.sort(arr);
        int temp0=0,temp1=0,temp2=0;
        temp0=arr[0]/3+arr[1]/3+arr[2]/3;
        if(arr[0]>=1){
            temp1=1+(arr[0]-1)/3+(arr[1]-1)/3+(arr[2]-1)/3;
        }
        if(arr[0]>=2){
            temp2=2+(arr[0]-2)/3+(arr[1]-2)/3+(arr[2]-2)/3;
        }
        System.out.println(max(temp0,temp1,temp2));
    }
    public static int max(int a,int b,int c){
        if(a>=b && a>=c)return a;
        else if(b>=a && b>=c)return b;
        else return c;
    }
}
