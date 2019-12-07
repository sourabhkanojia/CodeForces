import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for(int i=0;i<=n;i++){
            if(i!=n) {
                for (int j = 1; j < n - i; j++) System.out.print("  ");
                System.out.print(" ");
            }
            if(i==n){
                for(int j=0;j<i;j++) System.out.print(j+" ");
                System.out.print(i);
            }
            else for(int j=0;j<=i;j++) System.out.print(" "+j);
            if(i!=0){
                for(int j=i-1;j>=0;j--) System.out.print(" "+j);
            }
            System.out.println();
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<n-i;j++) System.out.print("  ");
            System.out.print(" ");
            for(int j=0;j<=i;j++) System.out.print(" "+j);
            if(i!=0){
                for(int j=i-1;j>=0;j--) System.out.print(" "+j);
            }
            System.out.println();
        }
    }
}
