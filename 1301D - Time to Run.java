import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    static LinkedList<Integer>[] ll;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int total=4*n*m-2*(n+m);
        if(k>total){
            System.out.println("NO");
            return;
        }
        int steps=0;
        StringBuilder sb=new StringBuilder();
        boolean z=false;
        int km=0;
        for(int i=0;i<n-1;i++){
            for(int j=1;j<m;j++){
                km++;
                sb.append("R");
                if(km==k){
                    z=true;
                    break;
                }
            }
            if(z)break;
            for(int j=m-2;j>=0;j--){
                km++;
                sb.append("L");
                if(km==k){
                    z=true;
                    break;
                }
            }
            if(z)break;
            sb.append("D");
            km++;
            if(km==k){
                z=true;
                break;
            }
        }
        for(int i=1;i<m && !z;i++){
            km++;
            sb.append("R");
            if(km==k){
                z=true;
                break;
            }
        }
        for(int i=m-1;i>=1 && !z;i--){
            for(int j=1;j<n;j++){
                km++;
                sb.append("U");
                if(km==k){
                    z=true;
                    break;
                }
            }
            if(z)break;
            for(int j=n-2;j>=0;j--){
                km++;
                sb.append("D");
                if(km==k){
                    z=true;
                    break;
                }
            }
            if(z)break;
            sb.append("L");km++;
            if(km==k){
                z=true;
                break;
            }
        }
        for(int i=n-2;i>=0 && !z;i--){
            sb.append("U");km++;
            if(km==k){
                z=true;
                break;
            }
        }
        StringBuilder sb2=new StringBuilder();
        int temp=1;
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i)==sb.charAt(i-1))temp++;
            else{
                sb2.append(temp+" "+sb.charAt(i-1)+"\n");
                temp=1;
                steps++;
            }
        }
        sb2.append(temp+" "+sb.charAt(sb.length()-1));
        steps++;

        System.out.println("YES\n"+steps);
        System.out.println(sb2);
    }
}
