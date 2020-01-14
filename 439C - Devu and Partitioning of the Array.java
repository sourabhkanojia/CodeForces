import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt(),p=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        LinkedList<Integer> even=new LinkedList<>();
        LinkedList<Integer> odd=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i]%2==0)even.add(arr[i]);
            else odd.add(arr[i]);
        }
        LinkedList<Integer>[] ll=new LinkedList[k];
        for(int i=0;i<k;i++)ll[i]=new LinkedList<>();
        k=k-p;
        int count=0;
        while(count<k){
            if(odd.isEmpty()){
                System.out.println("NO");
                return;
            }
            ll[count++].add(odd.removeFirst());
        }
        while(count<k+p){
            if(even.isEmpty()){
                if(odd.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                else if(odd.size()>=2){
                    ll[count].add(odd.removeFirst());
                    ll[count++].add(odd.removeFirst());
                }
                else{
                    System.out.println("NO");
                    return;
                }
            }
            else ll[count++].add(even.removeFirst());
        }
        while(!odd.isEmpty()){
            if(odd.size()==1){
                System.out.println("NO");
                return;
            }
            else{
                ll[count-1].add(odd.removeFirst());
                ll[count-1].add(odd.removeFirst());
            }
        }
        while(!even.isEmpty()){
            ll[count-1].add(even.removeFirst());
        }
        System.out.println("YES");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k+p;i++){
            sb.append(ll[i].size()+" ");
            for(int j:ll[i])sb.append(j+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
