import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int  n=sc.nextInt();
            int two=0,three=0;
            while(n%2==0){
                n/=2;
                two++;
            }
            while(n%3==0){
                n/=3;
                three++;
            }
            if(n>1)sb.append(-1);
            else{
                if(two==three)sb.append(two);
                else if(two>three)sb.append(-1);
                else{
                    int ans=(three-two);
                    two+=(three-two);
                    ans+=three;
                    sb.append(ans);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
