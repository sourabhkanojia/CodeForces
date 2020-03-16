import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static long INF=(long)1e18;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        boolean[] present=new boolean[3002];
        for(int i=0;i<n;i++){
            present[sc.nextInt()]=true;
        }
        for(int i=1;i<=3001;i++){
            if(!present[i]){
                System.out.println(i);
                return;
            }
        }
    }
}
