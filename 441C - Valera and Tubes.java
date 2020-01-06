import java.awt.Point;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int[][] arr=new int[n][m];
        for(int[] i:arr)Arrays.fill(i,-1);
        int z=n*m/k;
        int x=k;
        int count=0;
        LinkedList<Point>[] ll=new LinkedList[k];
        for(int i=0;i<k;i++)ll[i]=new LinkedList<>();
        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                arr[i][j]=x;
                ll[x-1].add(new Point(i+1,j+1));
                count++;
                if(count==z){
                    count=0;
                    x--;
                }
                if(x==0)x=1;
            }
            if(i==n-1 && arr[i][m-1]!=-1)break;
            i++;
            for(int j=m-1;j>=0;j--){
                arr[i][j]=x;
                ll[x-1].add(new Point(i+1,j+1));
                count++;
                if(count==z){
                    count=0;
                    x--;
                }
                if(x==0)x=1;
            }
        }
        for(int i=0;i<k;i++){
            System.out.print(ll[i].size()+" ");
            for(Point p:ll[i]) System.out.print(p.x+" "+p.y+" ");
            System.out.println();
        }
    }
}
