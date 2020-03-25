import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int[] L;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int l=0,r=s.length()-1;
            while(l<r){
                if(s.charAt(l)==s.charAt(r)){
                    l++;
                    r--;
                }
                else{
                    l--;
                    r++;
                    break;
                }
            }
            if(r==l){
                sb.append(s+"\n");
                continue;
            }
            if(s.length()==1){
                sb.append(s+"\n");
                continue;
            }
            if(r==l-1){
                sb.append(s+"\n");
                continue;
            }
            String temp=s.substring(l+1,r);
            manacher(temp);
            int right=0;
            for(int i=1;i<L.length;i++){
                if(L[i]==i)right=i;
            }
            int left=0;
            int c=1;
            for(int i=L.length-3;i>=1;i--){
                if(L[i]==c){
                    left=c;
                }
                c++;
            }
            for(int i=0;i<=l;i++)sb.append(s.charAt(i));
            if(right>left){
                for(int i=0;i<right;i++)sb.append(temp.charAt(i));
            }
            else{
                for(int i=temp.length()-1;temp.length()-1-i<left;i--)sb.append(temp.charAt(i));
            }
            for(int i=r;i<s.length();i++)sb.append(s.charAt(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void manacher(String text){
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        start = -1;
        end = -1;
        int diff = -1;

        for (i = 2; i < N; i++) {
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) ==
                                    text.charAt((i - L[i] - 1) / 2)))) { L[i]++; }

            if (L[i] > maxLPSLength) {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }
        }
    }
}
