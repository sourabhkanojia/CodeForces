import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] r=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++)r[i]=sc.nextInt();
        for(int i=0;i<n;i++)b[i]=sc.nextInt();
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if(r[i]==1 && b[i]==0)x++;
            else if(r[i]==0 && b[i]==1)y++;
        }
        if(x==0){
            System.out.println(-1);
            return;
        }
        if(x<y){
            int diff=y-x;
            System.out.println((int)Math.ceil(++diff/(double)x)+1);
        }
        else if(x==y){
            if(x>0)System.out.println(2);
            else System.out.println(-1);
        }
        else System.out.println(1);
    }
}
