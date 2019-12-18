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
        int n=sc.nextInt();
        int m=sc.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.next();
        }
        HashSet[] hs=new HashSet[m];
        for(int i=0;i<m;i++)hs[i]=new HashSet<Character>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                hs[i].add(str[j].charAt(i));
            }
        }
        long ans=1;
        for(int i=0;i<m;i++){
            ans=ans*hs[i].size()%1000000007;
        }
        System.out.println(ans);
    }
}
