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
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        char[] s1=sc.nextLine().toCharArray();
        char[] s2=sc.nextLine().toCharArray();
 
        int count=0;
        for(int i=0;i<n;i++){
            if(s1[i]!=s2[i]){
                if(i==n-1){
                    count++;
                    continue;
                }
                if(s1[i]=='0'){
                    if(s1[i+1]=='1' && s2[i+1]=='0'){
                        count++;
                        s1[i]='1';
                        s1[i+1]='0';
                    }
                    else count++;
                }
                else{
                    if(s1[i+1]=='0' && s2[i+1]=='1'){
                        count++;
                        s1[i]='0';
                        s1[i+1]='1';
                    }
                    else count++;
                }
            }
        }
        System.out.println(count);
    }
}
