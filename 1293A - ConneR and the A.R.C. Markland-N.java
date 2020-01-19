import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int s=sc.nextInt();
            int k=sc.nextInt();
            HashSet<Integer> hs=new HashSet<>();
 
            for(int i=0;i<k;i++)hs.add(sc.nextInt());
            int a=s;
            for(int i=s;i<=n;i++){
                if(!hs.contains(i)){
                    a=i;
                    break;
                }
                if(i==n){
                    a=Integer.MAX_VALUE;
                }
            }
            int b=s;
            for(int i=s;i>=1;i--){
                if(!hs.contains(i)){
                    b=i;
                    break;
                }
                if(i==1)b=Integer.MAX_VALUE;
            }
            System.out.println(Integer.min(a-s,Math.abs(s-b)));
        }
    }
}
