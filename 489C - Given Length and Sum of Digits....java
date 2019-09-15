import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int s=n;
 
        if(n>9*m){
            System.out.println("-1 -1");
            return;
        }
        if(n==0){
            if(m==1) System.out.println("0 0");
            else System.out.println("-1 -1");
            return;
        }
 
        int[] a=new int[m];
        int i;
        for(i=m-1;i>=0;i--){
            if(n>9) {
                a[i] = 9;
                n -= 9;
            }
            else{
                a[i]=n;
                break;
            }
        }
 
 
        if(i!=0){
            a[i]--;
            a[0]=1;
        }
        for(int j=0;j<m;j++) System.out.print(a[j]);
        System.out.print(" ");
 
        Arrays.fill(a,0);
        for(i=0;i<m;i++){
            if(s>9){
                a[i]=9;
                s-=9;
            }
            else{
                a[i]=s;
                break;
            }
        }
        for(int j=0;j<m;j++) System.out.print(a[j]);
 
 
 
    }
 
}
class node implements Comparable<node>{
    int n;
    int index;
 
    public node(int n,int index){
        this.n=n;
        this.index=index;
    }
 
    @Override
    public String toString() {
        return "node{" +
                "n=" + n +
                ", index=" + index +
                '}';
    }
 
    public int compareTo(node m){
        return this.n-m.n;
    }
}
