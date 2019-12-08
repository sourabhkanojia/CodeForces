import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
        int m=Integer.max(3*a/10,a-(a/250)*c);
        int v=Integer.max(3*b/10,b-(b/250)*d);
        if(m>v) System.out.println("Misha");
        else if(v>m) System.out.println("Vasya");
        else System.out.println("Tie");
    }
}
