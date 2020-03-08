import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> odd=new ArrayList<>(100);
        int ans=0;
        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            if((temp&1)==1)odd.add(temp);
            else ans+=temp;
        }
        if(odd.size()==0){
            System.out.println(0);
            return;
        }
        Collections.sort(odd);
        int i=0;
        if(odd.size()%2==0)i=1;
        for(;i<odd.size();i++)ans+=odd.get(i);
        System.out.println(ans);
    }
}
