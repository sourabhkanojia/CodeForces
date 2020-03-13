import java.io.*;
import java.util.*;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            boolean z=false;
            for(int i=0;i<n;i++){
                for(int j=i+2;j<n;j++){
                    if(arr[i]==arr[j]){
                        z=true;
                    }
                }
                if(z)break;
            }
            if(z)sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
