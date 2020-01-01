import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[200002];
        HashSet<Integer> hs=new HashSet<>();
        int temp;
        for(int i=0;i<n;i++){
            temp=sc.nextInt();
            arr[temp]++;
            hs.add(temp);
        }
        System.out.println(min(arr)+" "+max(arr));
    }
    public static int min(int[] arr){
        int res=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>0){
                res++;
                i+=2;
            }
        }
        return res;
    }
    public static int max(int[] arr){
        int res = 0;
        int dist = 2;
        boolean right = false;
        for(int i=0;i<arr.length;i++){
            if (arr[i]==0){
                ++dist;
                continue;
            }
            int j = i - 1;
            int sum = 0;
            while (j + 1 < arr.length && arr[j + 1]>0){
                ++j;
                sum += arr[j];
            }
            res += (j - i + 1);
            if (sum > j - i + 1 && (!right || dist > 1)){
                --sum;
                ++res;
            }
            right = false;
            if (sum > j - i + 1){
                right = true;
                ++res;
            }
            i = j;
            dist = 0;
        }
        return res;
    }
}
