import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("polycarp",1);
        int ans=1;
        for(int i=0;i<n;i++){
            String a=sc.next().toLowerCase();
            sc.next();
            String b=sc.next().toLowerCase();
            hm.put(a,hm.get(b)+1);
            ans=Math.max(ans,hm.get(a));
        }
        System.out.println(ans);
    }
}
