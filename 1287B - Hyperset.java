import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++)str[i]=sc.next();
        ArrayList<String> arr=new ArrayList<>();
        StringBuilder sb;
        for(int i=0;i<n;i++){
            String a=str[i];
            for(int j=i+1;j<n;j++){
                String b=str[j];
                sb=new StringBuilder();
                for(int k=0;k<m;k++){
                    if(a.charAt(k)!=b.charAt(k)){
                        if(a.charAt(k)!='S' && b.charAt(k)!='S')sb.append('S');
                        else if (a.charAt(k)!='T' && b.charAt(k)!='T')sb.append('T');
                        else if (a.charAt(k)!='E' && b.charAt(k)!='E')sb.append('E');
                    }
                    else sb.append(a.charAt(k));
                }
                arr.add(sb.toString());
            }
        }
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(str[i])){
                int count=hm.get(str[i]);
                hm.replace(str[i],count,count+1);
            }
            else hm.put(str[i],1);
        }
        int count=0;
        for(int i=0;i<arr.size();i++){
            if(hm.containsKey(arr.get(i))){
                count+=hm.get(arr.get(i));
            }
        }
        System.out.println(count/3);
    }
}
