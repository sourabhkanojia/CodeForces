import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int t=sc.nextInt();
        int r=sc.nextInt();
        int[] arr=new int[m];
        for(int i=0;i<m;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int[] z=new int[1000];
        int count=0;
        for(int i=0;i<m;i++){
            int j=arr[i];
            if(z[arr[i]]<r){
                int inc=r-z[arr[i]];
                count+=inc;
                for(int k=1;k<=inc;k++){
                    for(int l=j;l<=j+t-1;l++){
                        if(l<0)continue;
                        z[l]++;
                    }
                    j--;
                }
            }
            if(z[arr[i]]<r){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}
