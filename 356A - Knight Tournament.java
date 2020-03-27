import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i=1;i<=n;i++)ts.add(i);
        int[] k=new int[n+1];
        for(int i=0;i<m;i++){
            int l=sc.nextInt(),r=sc.nextInt(),x=sc.nextInt();
            boolean z=true;
            while (z){
                Integer temp=ts.ceiling(l);
                if(temp!=null && temp<=r){
                    if(temp==x){
                        l=x+1;
                        continue;
                    }
                    k[temp]=x;
                    ts.remove(temp);
                }
                else z=false;
            }
        }
        for(int i=1;i<=n;i++)sb.append(k[i]+" ");
        System.out.println(sb);
    }
}
