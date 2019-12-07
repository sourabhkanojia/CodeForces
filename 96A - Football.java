import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        int count=0;
        char current=s.charAt(0);
        count++;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==current)count++;
            else {
                current=s.charAt(i);
                count=1;
            }
            if(count==7) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
