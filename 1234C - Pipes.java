import java.util.Arrays 
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
 
public class problems {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q-->0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int i=1,j=1;
            boolean x=true;
            int z=0;
            for(int k=0;k<n;k++){
                if(x){
                    if(s1.charAt(k)=='1' || s1.charAt(k)=='2'){
                        if(z==0) j++;
                        else break;
                    }
                    else{
                        if(z==0) {
                            x = false;
                            i++;
                            k--;
                            z = 1;
                        }
                        else{
                            z=0;
                            j++;
                        }
                    }
                }
                else{
                    if(s2.charAt(k)=='1' || s2.charAt(k)=='2'){
                        if(z==0) j++;
                        else break;
                    }
                    else{
                        if (z == 0) {
                            i--;
                            x=true;
                            k--;
                            z=1;
                        }
                        else{
                            z=0;
                            j++;
                        }
                    }
                }
            }
            if(i==2 && j==n+1) System.out.println("YES");
            else System.out.println("NO");
 
        }
    }
}
