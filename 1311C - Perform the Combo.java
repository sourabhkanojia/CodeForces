import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),p=sc.nextInt();
            String s=sc.next();
            int[] arr=new int[p];
            for(int i=0;i<p;i++)arr[i]=sc.nextInt()-1;
            int[] temp=new int[n];
 
            for(int i=0;i<p;i++){
                temp[arr[i]]++;
            }
            for(int i=n-2;i>=0;i--){
                temp[i]+=temp[i+1];
            }
 
            int[] c=new int[26];
 
            for(int i=0;i<n;i++){
                c[s.charAt(i)-'a']+=temp[i];
            }
            for(int i=0;i<n;i++){
                c[s.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++) {
                sb.append(c[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
