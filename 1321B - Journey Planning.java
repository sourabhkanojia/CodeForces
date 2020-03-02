import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        HashMap<Integer,Long> hm = new HashMap<Integer,Long>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            int x = nums[i]-i;
            hm.put(x, hm.getOrDefault(x, 0L)+(x+i+0L));
        }
        long ans = 0;
        for (int key: hm.keySet()) ans = Math.max(ans,hm.get(key));
        System.out.println(ans);
    }
}
