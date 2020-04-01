import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)arr[i]=sc.nextInt();
            int[] res = new int[n];
            int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
            int col = 1;
            for(int p: primes)
            {
                ArrayList<Integer> loc = new ArrayList<Integer>();
                for(int i=0; i < n; i++)
                {
                    int x = arr[i];
                    if(x%p == 0 && res[i] == 0)
                        loc.add(i);
                }
                if(loc.size() > 0)
                {
                    for(int x: loc)
                        res[x] = col;
                    col++;
                }
            }
            sb.append(col-1);
            sb.append("\n");
            for(int x: res)
                sb.append(x+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
