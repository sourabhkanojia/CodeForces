import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc .nextInt();
        int m=sc.nextInt();
        int[] a=new int[m];
        for(int i=0;i<m;i++){
            a[i]=sc.nextInt();
        }
        long count=0;
        int current=1;
        for(int i=0;i<m;i++){
            if(a[i]>current){
                count=count+(a[i]-current);
                current=a[i];
            }
            else if(a[i]<current){
                count=count+(n-current)+a[i];
                current=a[i];
            }
        }
        System.out.println(count);
    }
}
