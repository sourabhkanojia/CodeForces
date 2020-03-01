import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        Integer[] a=new Integer[n];
        Integer[] b=new Integer[m];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i=0;i<m;i++)b[i]=sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        long sum=0;
        m=Math.min(n,m);
        for(int i=0;i<m;i++){
            if(b[i]>a[i])sum+=b[i]-a[i];
        }
        System.out.println(sum);
    }
}
