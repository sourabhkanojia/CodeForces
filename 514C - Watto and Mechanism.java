import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+9;
    static long[] pow;
    static long p=11;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        Set<Long> hs=new HashSet<>();
        pow=new long[1000*1000+1];
        pow[0]=1;
        for(int i=1;i<pow.length;i++){
            pow[i]=(p*pow[i-1])%mod;
        }
        for(int i=0;i<n;i++){
            hs.add(computeHash(sc.next().toCharArray()));
        }
        for(int i=0;i<m;i++){
            char[] temp=sc.next().toCharArray();
            long val=computeHash(temp);
            boolean z=false;
            for(int j=0;j<temp.length && !z;j++){
                char x=temp[j];
                long res=(x*pow[j])%mod;
                val-=res;
                for(char c='a';c<='c' && !z;c++){
                    if(c!=x){
                        long newRes=(c*pow[j])%mod;
                        val+=newRes;
                        z=hs.contains(val);
                        val-=newRes;
                    }
                }
                val+=res;
            }
            if(z)sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
    static long computeHash(char[] c){
        long hashvalue=0;
        for(int i=0;i<c.length;i++){
            hashvalue+=(c[i]*pow[i])%mod;
        }
        return hashvalue;
    }
}
