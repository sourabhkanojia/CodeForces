import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;

public class Main {
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[26];
        long[][] freq=new long[26][26];
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            for(int j=0;j<26;j++){
                freq[j][c]+=arr[j];
            }
            arr[c]++;
        }
        long max=0;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++)max=Math.max(max,freq[i][j]);
            max=Math.max(max,arr[i]);
        }
        System.out.println(max);
    }
}
