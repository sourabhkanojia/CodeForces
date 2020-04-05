import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n+1];
            int max=0;
            for(int i=1;i<=n;i++){
                arr[i]=sc.nextInt();
                max=Math.max(max,arr[i]);
            }
            int min=n-max;
            HashSet<Integer> hs=new HashSet<>();
            boolean z1=true;
            for(int i=1;i<=max;i++)hs.add(arr[i]);
            for(int i=1;i<=max;i++){
                if(!hs.contains(i)){
                    z1=false;
                    break;
                }
            }
            if(z1){
                hs=new HashSet<>();
                for(int i=max+1;i<=n;i++)hs.add(arr[i]);
                for(int i=1;i<=min;i++){
                    if(!hs.contains(i)){
                        z1=false;
                        break;
                    }
                }

            }
            boolean z2=true;
            hs=new HashSet<>();
            for(int i=1;i<=min;i++)hs.add(arr[i]);
            for(int i=1;i<=min;i++){
                if(!hs.contains(i)){
                    z2=false;
                    break;
                }
            }
            if(z2){
                hs=new HashSet<>();
                for(int i=min+1;i<=n;i++)hs.add(arr[i]);
                for(int i=1;i<=max;i++){
                    if(!hs.contains(i)){
                        z2=false;
                        break;
                    }
                }
            }
            if(z1 && z2 && max!=min)sb.append(2+"\n"+max+" "+min+"\n"+min+" "+max+"\n");
            else if(z1)sb.append(1+"\n"+max+" "+min+"\n");
            else if(z2)sb.append(1+"\n"+min+" "+max+"\n");
            else sb.append(0+"\n");
        }
        System.out.println(sb);
    }
}
