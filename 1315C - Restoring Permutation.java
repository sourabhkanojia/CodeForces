import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.Point;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(Sytem.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] b=new int[n];
            boolean[] c=new boolean[2*n+1];
            for(int i=0;i<n;i++)c[b[i]=sc.nextInt()]=true;
            TreeSet<Integer> treeSet=new TreeSet<>();
            for(int i=1;i<=2*n;i++){
                if(!c[i])treeSet.add(i);
            }
            StringBuilder temp=new StringBuilder();
            boolean z=false;
            for(int i=0;i<n;i++){
                Integer x=treeSet.higher(b[i]);
                if(x==null){
                    z=true;
                    break;
                }
                temp.append(b[i]+" "+x+" ");
                treeSet.remove(x);
            }
            if(z)sb.append("-1\n");
            else sb.append(temp+"\n");
        }
        System.out.println(sb);
    }
}
