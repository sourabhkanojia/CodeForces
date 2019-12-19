import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        for(int i=0;i<s.length();i++){
            if((s.charAt(i)-'0')%8==0){
                System.out.println("YES\n"+(s.charAt(i)-'0'));
                return;
            }
            if(i+1<s.length()) {
                for (int j = i + 1; j < s.length(); j++) {
                    int temp1 = Integer.parseInt("" + (s.charAt(i) - '0') + (s.charAt(j) - '0'));
                    if (temp1 % 8 == 0) {
                        System.out.println("YES\n"+temp1);
                        return;
                    }
                    if(j+1<s.length()) {
                        for (int k = j + 1; k < s.length(); k++) {
                            int temp = Integer.parseInt("" + (s.charAt(i) - '0') + (s.charAt(j) - '0') + (s.charAt(k) - '0'));
                            if (temp % 8 == 0) {
                                System.out.println("YES\n"+temp);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
