import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
imort java.util.Scanner;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        String a=sc.nextLine();
        String b=sc.nextLine();

        char[] c=new char[a.length()];
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='0'){
                if(b.charAt(i)=='1'){
                    c[i]='1';
                }
                else{
                    c[i]='0';
                }
            }
            else{
                if(b.charAt(i)=='0'){
                    c[i]='1';
                }
                else{
                    c[i]='0';
                }
            }
        }
        System.out.println(c);
    }
}
