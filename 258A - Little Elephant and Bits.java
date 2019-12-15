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
        StringBuilder sb=new StringBuilder(sc.nextLine());
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0'){
                sb.replace(i,i+1,"");
                System.out.println(sb);
                return;
            }
        }
        sb.replace(0,1,"");
        System.out.println(sb);
    }
}
