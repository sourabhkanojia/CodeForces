import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        TreeSet<Node> ts=new TreeSet<>();  // Also we can use array of Node then sort it.
        for(int i=1;i<=n;i++){
            ts.add(new Node(sc.nextInt(),i));
        }

        int[] b=new int[n];
        String s=sc.nextLine();
        s=" "+s;
        for(int i=1;i<=n-1;i++){
            b[i]=s.charAt(i)-48;
        }
        for(int i=2;i<=n-1;i++)b[i]+=b[i-1];  //Prefix sum of allowed swaps.

        for(int i=1;i<=n;i++){
            int j=ts.pollFirst().index;
            if(j-i>b[j-1]-b[i-1]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
class Node implements Comparable<Node>{
    int value,index;
    public Node(int value,int index){
        this.value=value;
        this.index=index;
    }
    public int compareTo(Node o){
        return this.value-o.value;
    }
}
