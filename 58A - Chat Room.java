import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        String a="hello";
        int j=0;
        int i;
        for(i=0;i<a.length();i++){
            while(j<s.length()){
                if(s.charAt(j)==a.charAt(i)){
                    if(i==4){
                        System.out.println("YES");
                        return;
                    }
                    j++;
                    break;
                }
                j++;
            }
            if(j==s.length()){
                System.out.println("NO");
                return;
            }
        }
    }
}
