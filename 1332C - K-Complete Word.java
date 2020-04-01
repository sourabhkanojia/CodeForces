import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(),k=sc.nextInt();
            String s=sc.next();
            char[][] c=new char[n/k][k];
            int j=0;
            for(int i=0;i<n/k;i++){
                c[i]=s.substring(j,j+k).toCharArray();
                j+=k;
            }
            int l=0,r=k-1,count=0;
            while(l<=r){
                int[] z=new int[26];
                for(int i=0;i<n/k;i++){
                    z[c[i][l]-'a']++;
                    z[c[i][r]-'a']++;
                }
                int max=0,ch=-1;
                for(int i=0;i<26;i++){
                    if(z[i]>max){
                        max=z[i];
                        ch=i;
                    }
                }
                char x=(char)(ch+'a');
                for(int i=0;i<n/k;i++){
                    if(c[i][l]!=x){
                        c[i][l]=x;
                        count++;
                    }
                    if(c[i][r]!=x){
                        c[i][r]=x;
                        count++;
                    }
                }
                l++;
                r--;
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
