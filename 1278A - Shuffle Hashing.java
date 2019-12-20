import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            StringBuilder a=new StringBuilder(sc.next()),b=new StringBuilder(sc.next());
            if(b.length()<a.length()) System.out.println("NO");
            else if(b.length()==a.length()){
                int[] count=new int[26];
                for(int i=0;i<a.length();i++){
                    count[a.charAt(i)-'a']++;
                }
                for(int i=0;i<b.length();i++){
                    count[b.charAt(i)-'a']--;
                }
                boolean x=true;
                for(int i=0;i<26;i++){
                    if(count[i]>0){
                        x=false;
                        break;
                    }
                }
                if(x) System.out.println("YES");
                else System.out.println("NO");
            }
            else{
                int temp=a.length();
                boolean x=true;
                int[] count=new int[26];
                for(int i=0;i<a.length();i++)count[a.charAt(i)-'a']++;
                StringBuilder c=new StringBuilder(" "+b.substring(0,temp-1));
                int[] test;
                for(int i=temp-1;i<b.length();i++){
                    c.replace(0,1,"");
                    c.append(b.subSequence(i,i+1));
                    test=new int[26];
                    for(int j=0;j<temp;j++){
                        test[c.charAt(j)-'a']++;
                    }
                    x=true;
                    for(int j=0;j<26;j++){
                        if(count[j]!=test[j]){
                            x=false;
                            break;
                        }
                    }
                    if(x)break;
                }
                if(x) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
