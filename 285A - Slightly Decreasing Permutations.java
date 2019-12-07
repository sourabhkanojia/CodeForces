import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();
        for(int i=1;i<n-k;i++) System.out.print(i+" ");
        for(int i=n-k;i<=n;i++) System.out.print(2*n-k-i+" ");
    }
}
