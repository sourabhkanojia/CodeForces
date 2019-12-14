import java.awt.dnd.Autoscroll;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='r')sb.append((i+1)+"\n");
        }
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='l')sb.append((i+1)+"\n");
        }
        System.out.println(sb);
    }
}
