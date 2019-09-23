import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
 
public class problems {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        char[] c=s.toCharArray();
        if(s.length()==1){
            if(k==0){
                System.out.println(s);
                return;
            }else{
                System.out.println(0);
                return;
            }
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if(c[i]!='1' && k>0) {
                    k--;
                    c[i] = '1';
                }
            }
            else if(c[i]!='0' && k>0){
                k--;
                c[i]='0';
            }
 
            if(k==0)break;
        }
        for(int i=0;i<s.length();i++) System.out.print(c[i]);
        System.out.println();
    }
}
 
 
 
