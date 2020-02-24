import java.util.*;
import java.io.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt(),m=sc.nextInt();
            int arr[]=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int pro[]=new int[101];
            for (int i=0;i<m;i++){
                pro[sc.nextInt()-1]=1;
            }
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (pro[j]==1){
                        if (arr[j]>arr[j+1]){
                            int temp2=arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=temp2;
                        }
                    }
                }
            }
            if (isTrue(arr)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static boolean isTrue(int arr[]){
        int n=arr.length;
        for (int i=0;i<n-1;i++){
            if (arr[i]>arr[i+1])return false;
        }
        return true;
    }
}
