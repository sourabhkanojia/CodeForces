import java.awt.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        StringBuilder sb=new StringBuilder();
        int[][] b=new int[r][c];
        boolean sol=false;
        int z=0;
 
        for(int i=0;i<r-1;i++){
            for(int j=0;j<c-1;j++){
                 boolean x=false;
                 if(arr[i][j]==1){
                     if(arr[i][j+1]==1){
                         if(arr[i+1][j]==1){
                             if(arr[i+1][j+1]==1){
                                 x=true;
                             }
                             else x=false;
                         }
                         else x=false;
                     }
                     else x=false;
                 }
 
                 if(x){
                     b[i][j]=1;
                     b[i][j+1]=1;
                     b[i+1][j]=1;
                     b[i+1][j+1]=1;
                     sb.append((i+1)+" "+(j+1)+"\n");
                     z++;
                 }
                 if(isTrue(arr,b,r,c)){
                     sol=true;
                     break;
                 }
            }
            if(sol)break;
        }
        if(sol) {
            System.out.println(z);
            System.out.println(sb);
        }
        else System.out.println(-1);
 
    }
    public static boolean isTrue(int[][] arr,int[][] b,int r,int c){
        boolean x=false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==b[i][j]){
                    x=true;
                }
                else{
                    x=false;
                    break;
                }
            }
            if(!x)break;
        }
 
        if(x)return true;
        else return false;
    }
 }
 
 
