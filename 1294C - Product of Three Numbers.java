import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            HashMap<Integer,Integer> hm= fac(n);
            int[] arr1=new int[hm.size()];
            int[] arr2=new int[hm.size()];
            int count=0;
            for (int x:hm.keySet()){
                arr1[count]=x;
                arr2[count]=hm.get(x);
                count++;
            }
            if (count>=3){
                System.out.println("YES");
                System.out.println(arr1[0]+" "+arr1[1]+" "+n/(arr1[0]*arr1[1]));
            }else if (count==2){
                if (arr2[0]+arr2[1]>=4){
                    System.out.println("YES");
                    System.out.println(arr1[0]+" "+arr1[1]+" "+(n/(arr1[0]*arr1[1])));
                }else System.out.println("NO");
            }else{
                if (arr2[0]>=6){
                    System.out.println("YES");
                    System.out.println(arr1[0]+" "+(arr1[0]*arr1[0])+" "+(n/(arr1[0]*arr1[0]*arr1[0])));
                }else System.out.println("NO");
            }
        }
    }
    static HashMap<Integer, Integer> fac(int x){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=2;i*i<=x;i++){
            int cnt=0;
            boolean f=false;
            while (x%i==0){
                f=true;
                x/=i;
                cnt++;
            }
            if (f)map.put(i,cnt);
        }
        if (x>1)map.put(x,map.getOrDefault(x,0)+1);
        return map;
    }
}
