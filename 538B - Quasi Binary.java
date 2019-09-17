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
        String s=br.readLine();
        int[][] a=new int[9][s.length()];
        int max=0;
        for(int i=0,c=0;i<s.length();i++,c++){
            int x=s.charAt(i)-48;
            if(x>max)max=x;
            for(int r=0;r<x;r++){
                a[r][c]=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<max;i++){
            boolean x=false;
            for(int j=0;j<s.length();j++){
                if(a[i][j]==1)x=true;
                if(x) sb.append(a[i][j]);
            }
            sb.append(" ");
        }
        System.out.println(max);
        System.out.println(sb);

    }
 }
