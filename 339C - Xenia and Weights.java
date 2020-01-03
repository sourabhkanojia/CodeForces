import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int m;
    static String s;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        s = sc.nextLine();
        m = sc.nextInt();
        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        boolean z=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') {
                Stack<Node> stack = new Stack<>();
                stack.push(new Node(i+1,i+1));
                if(dfs(stack,z)==1){
                    System.out.println("YES");
                    int[] arr=new int[m];
                    for(int j=m-1;j>=0;j--)arr[j]=stack.pop().y;
                    for(int j=0;j<m;j++) System.out.print(arr[j]+" ");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
    public static int dfs(Stack<Node> stack,boolean z){
        if(stack.size()==m)return 1;
        int j=Math.abs(stack.peek().x);
        for(int i=j;i<s.length();i++){
            if(s.charAt(i)=='1' && stack.peek().y!=i+1) {
                if (z) {
                    stack.push(new Node(j-(i+1),i+1));
                    if(dfs(stack,false)==1)return 1;
                    stack.pop();
                } else {
                    stack.push(new Node(-j+i+1,i+1));
                    if(dfs(stack,true)==1)return 1;
                    stack.pop();
                }
            }
        }
        return -1;
    }
}
class Node{
    int x,y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
