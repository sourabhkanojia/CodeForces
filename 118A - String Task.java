import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        char[] c=sc.nextLine().toLowerCase().toCharArray();

        for(int i=0;i<c.length;i++){
            if(c[i]=='A' || c[i]=='a' || c[i]=='E' || c[i]=='e' || c[i]=='I' || c[i]=='i' || c[i]=='O' ||
                    c[i]=='o' || c[i]=='U' || c[i]=='u' || c[i]=='Y' || c[i]=='y'){
                c[i]='\0';
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i]!='\0'){
                System.out.print("."+c[i]);
            }
        }
    }
}
