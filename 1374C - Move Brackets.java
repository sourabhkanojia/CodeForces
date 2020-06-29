import java.awt.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int  n=sc.nextInt();
            char[] c=sc.next().toCharArray();
            int count=0;
            int move=0;
            for(int i=0;i<n;i++){
                if(c[i]=='(')count++;
                else{
                    if(count==0)move++;
                    else count--;
                }
            }
            sb.append(move+"\n");
        }
        System.out.println(sb);
    }
}
