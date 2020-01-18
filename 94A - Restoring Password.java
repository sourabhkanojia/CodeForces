import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String password=sc.nextLine();
        String[] nums=new String[10];
        for(int i=0;i<10;i++)nums[i]=sc.nextLine();
        for(int i=0;i<80;i+=10){
            if(i+10>81)break;
            String temp=password.substring(i,i+10);
            for(int s=0;s<10;s++){
                if(temp.equals(nums[s])) System.out.print(s);
            }
        }
    }
}
