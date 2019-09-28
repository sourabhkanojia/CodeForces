import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        char[] c=sc.nextLine().toCharArray();
        int count=0;

        for(int i=0;i<n-1;i++){
            if(c[i]==c[i+1]){
                count++;
                if(i+2<n){
                    if(c[i]==c[i+2]){
                        if(c[i]=='B')c[i+1]='R';
                        if(c[i]=='R')c[i+1]='B';
                        if(c[i]=='G')c[i+1]='B';
                    }
                    else if((c[i]=='R' && c[i+2]=='B') || c[i]=='B' && c[i+2]=='R')c[i+1]='G';
                    else if((c[i]=='R' && c[i+2]=='G') || c[i]=='G' && c[i+2]=='R')c[i+1]='B';
                    else if((c[i]=='G' && c[i+2]=='B') || c[i]=='B' && c[i+2]=='G')c[i+1]='R';
                }
                else{
                    if(c[i]=='B')c[i+1]='R';
                    else if(c[i]=='R')c[i+1]='B';
                    else if(c[i]=='G')c[i+1]='B';
                }
                i++;
            }
        }
        System.out.println(count);
        System.out.println(c);
    }
}

