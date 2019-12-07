import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        String s=sc.nextLine();

        int x=a.length();
        int y=b.length();
        int z=s.length();
        if(z!=x+y) System.out.println("NO");
        else{
            int[] arr=new int[26];
            for(int i=0;i<x;i++){
                arr[a.charAt(i)-'A']++;
            }
            for(int i=0;i<y;i++){
                arr[b.charAt(i)-'A']++;
            }
            for(int i=0;i<z;i++){
                arr[s.charAt(i)-'A']--;
                if(arr[s.charAt(i)-'A']<0){
                    System.out.println("NO");return;
                }
            }
            for(int i=0;i<26;i++){
                if(arr[i]!=0){
                    System.out.println("NO");return;
                }
            }
            System.out.println("YES");
        }
     }
}
