import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        String[] names=new String[n];
        int[] scores=new int[n];
        for(int i=0;i<n;i++){
            names[i]=sc.next();
            scores[i]=sc.nextInt();
        }
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(names[i])){
                scores[i]+=hm.get(names[i]);
                hm.put(names[i],scores[i]);
            }
            else hm.put(names[i],scores[i]);
        }
        int ans=Collections.max(hm.values());
        for(int i=0;i<n;i++){
            if(hm.get(names[i])==ans && ans<=scores[i]){
                System.out.println(names[i]);
                break;
            }
        }
    }
}
