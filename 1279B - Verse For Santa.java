import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int s=sc.nextInt();
            int[] arr=new int[n];
            long total=0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                total+=arr[i];
            }
            if(total<=s) System.out.println(0);
            else{int max=0;
                 int index=-1;
                for(int i=0;i<n;i++){
                    if(arr[i]>max){
                        max=arr[i];
                        index=i;
                    }
                    if(s<arr[i]) {
                        if(i==n-1 && arr[i]-s<=max){
                            System.out.println(index+1);
                            break;
                        }
                        else if(i+1<n && arr[i]+arr[i+1]-s<=max){
                            System.out.println(index+1);
                            break;
                        }
                    }
                    else s-=arr[i];
                }
            }
 
        }
    }
}
