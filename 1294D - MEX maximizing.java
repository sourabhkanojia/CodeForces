import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt(),x=sc.nextInt();
        TreeSet<Integer> array[]=new TreeSet[5*100000];
        for (int i=0;i<array.length;i++)array[i]=new TreeSet<>();
        TreeSet<Integer> treeset=new TreeSet<>();
        for (int i=0;i<500000;i++){
            array[i%x].add(i);
            treeset.add(i);
        }
        StringBuilder sb=new StringBuilder();
        while (q-->0){
            int z=sc.nextInt();
            if (!array[z%x].isEmpty()){
                int a=array[z%x].pollFirst();
                treeset.remove(a);
            }
            sb.append(treeset.first()+"\n");
        }
        System.out.print(sb);
    }
}
