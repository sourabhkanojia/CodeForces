import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        Arrays.sort(arr);
        if(n==1) System.out.println(-1);
        else{
            HashSet<Integer> hs=new HashSet<>();
            for(int i=1;i<n;i++){
                hs.add(arr[i]-arr[i-1]);
            }
            if(hs.size()>2){
                System.out.println(0);
                return;
            }
            if(hs.size()==1){
                int diff=arr[1]-arr[0];
                if(diff==0) System.out.println(1+"\n"+arr[1]);
                else if(n==2 && diff>=2 && diff%2==0){
                    System.out.println(3+"\n"+(arr[0]-diff)+" "+(arr[1]-diff/2)+" "+(arr[1]+diff));
                }
                else System.out.println(2+"\n"+(arr[0]-diff)+" "+(arr[n-1]+diff));
                return;
            }
            int one=-1,two=-1,i=0;
            for(int j:hs){
                if(i%2==0) {
                    one = j;
                    i++;
                }
                else two=j;
            }
            int count1=0,count2=0;
            for(i=1;i<n;i++){
                if(arr[i]-arr[i-1]==one)count1++;
                else count2++;
            }
            if(one==two*2 || two==one*2){
                if(count1>1 && count2>1) System.out.println(0);
                else if(count1==1 && count2>1){
                    if(one<two) System.out.println(0);
                    else {
                        i=1;
                        for(;i<n;i++){
                            if(arr[i]-arr[i-1]==one){
                                break;
                            }
                        }
                        System.out.println(1+"\n"+(arr[i]-two));
                    }
                }
                else if(count2==1 && count1>1){
                    if(two<one) System.out.println(0);
                    else{
                        i=1;
                        for(;i<n;i++){
                            if(arr[i]-arr[i-1]==two){
                                break;
                            }
                        }
                        System.out.println(1+"\n"+(arr[i]-one));
                    }
                }
                else{
                    if(one<two){
                        if(arr[2]-arr[1]==two) System.out.println(1+"\n"+(arr[2]-one));
                        else System.out.println(1+"\n"+(arr[1]-one));
                    }
                    else{
                        if(arr[2]-arr[1]==one) System.out.println(1+"\n"+(arr[2]-two));
                        else System.out.println(1+"\n"+(arr[1]-two));
                    }
                }
            }
            else System.out.println(0);
        }
    }
}
