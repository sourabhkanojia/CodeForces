import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static HashSet<String> hs=new HashSet<>();
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        StringBuilder a=new StringBuilder(sc.next()),b=new StringBuilder(sc.next());
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                if(b.charAt(i)-a.charAt(i)>1) {
                    a.replace(i,i+1,Character.toString((char)(a.charAt(i)+1)));
                    System.out.println(a);
                    return;
                }
                else{
                    if(i==b.length()-1){
                        System.out.println("No such string");
                        return;
                    }
                    if(a.charAt(i+1)=='z') {
                        a.replace(i, i + 1, Character.toString((char) (a.charAt(i) + 1)));
                        a.replace(i + 1, a.length(), "");
                        for (int j = i + 1; j < b.length(); j++) a.append('a');
                        boolean z = false;
                        for (int j = i + 1; j < b.length(); j++) {
                            if (b.charAt(j) > 'a') {
                                z = true;
                                break;
                            }
                        }
                        if (z) System.out.println(a);
                        else System.out.println("No such string");
                        return;
                    }
                    else{
                        a.replace(i+1,i+2,Character.toString((char) (a.charAt(i+1) + 1)));
                        System.out.println(a);
                        return;
                    }
                }
            }
        }
        System.out.println("No such string");
    }
}
