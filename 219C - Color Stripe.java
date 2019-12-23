import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String agr[]) {
        FastReader sc = new FastReader();
        int n=sc.nextInt(),k=sc.nextInt();
        char arr[]=sc.next().toCharArray();
        int cnt=0;
        if (k==2){
            String s[]=strings(n);
            int diff=0,diff1=0;
            for (int i=0;i<2;i++){
                for (int j=0;j<n;j++){
                    if (s[i].charAt(j)!=arr[j]&&i==0)diff++;
                    if (s[i].charAt(j)!=arr[j]&&i==1)diff1++;
                }
            }
            if (diff>=diff1){
                System.out.println(diff1);
                System.out.println(s[1]);
            }else {
                System.out.println(diff);
                System.out.println(s[0]);
            }
        }else {
            for (int i = 0; i < n; i++) {
                char x = arr[i];
                boolean vis = false;
                int j = i;
                while (j < n && x == arr[j]) {
                    j++;
                    vis = true;
                }
                if (vis) {
                    int chnge = (j - i) / 2;
                    cnt += chnge;
                    char chr = get(i, j, arr);
                    for (int a = i + 1; a < j; a += 2) {
                        arr[a] = chr;
                    }
                    i = j - 1;
                }
            }
            System.out.println(cnt);
            System.out.println(String.valueOf(arr));
        }
    }
    static String[] strings(int n){
        StringBuilder sb=new StringBuilder(),sb1=new StringBuilder();
        for (int i=0;i<n;i++){
            if (i%2==0){
                sb.append('A');
                sb1.append('B');
            }
            else {
                sb.append('B');
                sb1.append('A');
            }
        }
        return new String[]{sb.toString(),sb1.toString()};
    }
    static char get(int i,int j,char arr[]){
        if (j==arr.length && arr[i]!='A')return 'A';
        else if (j==arr.length && arr[i]!='B')return 'B';
        char res=arr[i]!='A' && arr[j]!='A'?'A':'0';
        if (res=='0')res=arr[i]!='B' && arr[j]!='B'?'B':'0';
        if (res=='0')res=arr[i]!='C' && arr[j]!='C'?'C':'0';
        return res;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
