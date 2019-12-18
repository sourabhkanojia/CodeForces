import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            hs.add(arr[i]);
        }
        int l=0,r=n-1;
        int[] cnt=new int[100001];
        for(int i=0;i<n;i++)cnt[arr[i]]++;
        int count=hs.size();
        if(count<k) System.out.println("-1 -1");
        else{
            while(true){
                if(cnt[arr[r]]>1){
                    cnt[arr[r]]--;
                    r--;
                }
                if(cnt[arr[l]]>1){
                    cnt[arr[l]]--;
                    l++;
                }
                if(count>k){
                    if(cnt[arr[r]]==1){
                        cnt[arr[r]]--;
                        r--;
                        count--;
                    }
                }
                if(count>k){
                    if(cnt[arr[l]]==1){
                        cnt[arr[l]]--;
                        l++;
                        count--;
                    }
                }
                if(count==k && cnt[arr[r]]==1 && cnt[arr[l]]==1){
                    System.out.println(++l+" "+(++r));
                    return;
                }
            }
        }
    }
}
