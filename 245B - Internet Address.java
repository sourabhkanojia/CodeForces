import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] c=sc.nextLine().toCharArray();
        StringBuilder sb=new StringBuilder();
        int i=0;
        if(c[i]=='f'){
            sb.append("ftp://");
            i+=3;
        }
        else{
            sb.append("http://");
            i+=4;
        }
        boolean z=false;
        for(;i<c.length;i++){
            if(!z && c[i]=='r' && sb.charAt(sb.length()-1)!='/'){
                if(i+1<c.length && c[i+1]=='u'){
                    sb.append(".ru/");
                    i++;
                    z=true;
                }
                else sb.append(c[i]);
            }
            else sb.append(c[i]);
        }
        if(sb.charAt(sb.length()-4)=='.')sb.replace(sb.length()-1,sb.length(),"");
        System.out.println(sb);
    }
}
