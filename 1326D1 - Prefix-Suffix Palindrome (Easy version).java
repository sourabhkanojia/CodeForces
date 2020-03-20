import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int n=s.length();
            s=" "+s;
            boolean[][] dp=new boolean[s.length()+1][s.length()+1];
            for(int i=1;i<=n;i++){
                dp[i][i]=true;
            }
            for(int i=1;i<n;i++){
                if(s.charAt(i)==s.charAt(i+1))dp[i][i+1]=true;
            }
            for(int len=0;len<n-2;len++){
                for(int i=1;i+len<n;i++){
                    if(dp[i][i+len] && s.charAt(i-1)==s.charAt(i+len+1)){
                        dp[i-1][i+len+1]=true;
                    }
                }
            }
            int l=1,r=n;
            while(s.charAt(l)==s.charAt(r)){
                l++; r--;
                if(r<=l)break;
            }
            l--;r++;
            if(l==r || l+1==r || l+2==r){
                sb.append(s.substring(1,n+1)+"\n");
                continue;
            }
            int left=l+1,right=r-1;
            for(int i=l+1;i<r;i++){
                if(dp[l+1][i]){
                    left=i;
                }
            }
            for(int i=r-1;i>l;i--){
                if(dp[i][r-1]){
                    right=i;
                }
            }
            if(left-l>r-right) sb.append(s.substring(1,left+1)+s.substring(r,n+1)+"\n");
            else sb.append(s.substring(1,l+1)+s.substring(right,n+1)+"\n");
        }
        System.out.println(sb);
    }
}
