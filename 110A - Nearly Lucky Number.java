import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        boolean a=false,b=false;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='4' || s.charAt(i)=='7')count++;
            if(count>7){
                System.out.println("NO");return;
            }
        }
        if(count==4 || count==7) System.out.println("YES");
        else System.out.println("NO");
    }
}
