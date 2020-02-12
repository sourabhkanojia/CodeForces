import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
 
public class Main {
    static int mod = (int) 1e9 + 7;
    static int[][] shows;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
        String s=sc.nextLine();
        LinkedList<Character> ll=new LinkedList<>();
        ll.add(s.charAt(0));
        int index=0;
        HashSet<Character> hs=new HashSet<>();
        hs.add(s.charAt(0));
        boolean z=false;
        for(int i=1;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                if(index>0 && ll.get(index-1).equals(s.charAt(i)))index--;
                else if(index<ll.size()-1 && ll.get(index+1).equals(s.charAt(i)))index++;
                else{
                    z=true;
                    break;
                    }
              }
            else{
              if(ll.size()-1==index){
                    ll.addLast(s.charAt(i));
                    index++;
                }
                else if(index==0){
                    ll.addFirst(s.charAt(i));
                    index=0;
                }
                else{
                    z=true;
                    break;
                    }
                    hs.add(s.charAt(i));
                }
            }
            if(z) System.out.println("NO");
            else{
                System.out.println("YES");
                for(Character c:ll) System.out.print(c);
                for(char i='a';i<='z';i++){
                    if(!hs.contains(i)) System.out.print(i);
                }
                System.out.println();
            }
        }
    }
}
