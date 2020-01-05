import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
 
 
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            char[] c=sc.next().toCharArray();
            int count=0;
            while(true){
                boolean z=true;
                for(int i=0;i<n-1;i++){
                    if(c[i]=='A' && c[i+1]=='P'){
                        c[i+1]='A';
                        i++;
                        z=false;
                    }
                }
                if(!z)count++;
                if(z)break;
            }
            System.out.println(count);
        }
 
    }
}
