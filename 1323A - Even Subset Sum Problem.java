import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            int ind=-1;
            ArrayList<Integer> ans=new ArrayList<>();
            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt()%2;
                if (arr[i]==0){
                    ind=i;
                }else ans.add(i+1);
            }
            if (ind!=-1){
                System.out.println(1);
                System.out.println(ind+1);
            }else if (ans.size()>=2){
                System.out.println(2);
                System.out.println(ans.get(0)+" "+ans.get(1));
            }else System.out.println(-1);
        }
    }
}
