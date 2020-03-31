import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int q=sc.nextInt();
        while(q-->0){
            int n=sc.nextInt();
            int[] t=new int[n];
            boolean z=true;
            for(int i=0;i<n;i++){
                t[i]=sc.nextInt();
                if(z){
                    if(i>0 && t[i]!=t[(i+1)%2])z=false;
                }
            }
            if(z){
                sb.append(1+"\n");
                for(int i=0;i<n;i++)sb.append(1+" ");
                sb.append("\n");
                continue;
            }

            if(n%2==0){
                sb.append(2+"\n");
                for(int i=0;i<n;i++){
                    sb.append(i%2+1+" ");
                }
                sb.append("\n");
                continue;
            }
            else{
                z=false;
                int index=-1;
                for(int i=0;i<n;i++){
                    if(t[i]==t[(i+1)%n]){
                        z=true;
                        index=i;
                        break;
                    }
                }
                if(z){
                    sb.append(2+"\n");
                    int count=1;
                    for(int i=0;i<n;i++){
                        if(i==index ){
                            sb.append(count+" ");
                            continue;
                        }
                        else if(i==index+1)sb.append(count+" ");
                        else sb.append(count+" ");

                        if(count==1)count=2;
                        else count=1;
                    }
                }
                else{
                    sb.append(3+"\n");
                    for(int i=0;i<n-1;i++)sb.append(i%2+1+" ");
                    sb.append(3);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
