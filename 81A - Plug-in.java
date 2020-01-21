import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String s=sc.nextLine();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(stack.isEmpty() || stack.peek()!=s.charAt(i))stack.push(s.charAt(i));
            else stack.pop();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}
