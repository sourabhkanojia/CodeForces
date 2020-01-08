import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),d=sc.nextInt();
        int[][] arr=new int[n][m];
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)sum+=arr[i][j]=sc.nextInt();
        }
        Integer[] b=new Integer[n*m];
        int k=0;
        int temp=arr[0][0]%d;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[k++]=arr[i][j];
                if(temp!=arr[i][j]%d){
                    System.out.println(-1);
                    return;
                }
            }
        }
        Arrays.sort(b);
        sum=0;
        int mid=(b.length/2)+1;
        for(int i:b){
            sum=sum+Math.abs(i-b[mid-1]);
        }
        System.out.println(sum/d);
    }
}
