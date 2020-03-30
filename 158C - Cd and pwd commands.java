import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int num = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for (int l = 0; l < num; l++) {
            int j = 0;
            String s = sc.next();
            if (!s.equals("pwd")) {
                s = sc.next();
                if (s.charAt(0) == '/') {
                    arr.clear();
                }
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '/' || s.charAt(i) == '.') {

                        if (i > j) {
                            arr.add(s.substring(j, i));
                        }
                        if (s.charAt(i) == '.') {
                            arr.remove(arr.size() - 1);
                            i++;
                        }
                        j = i + 1;
                    }
                }
                if (j < s.length()) {
                    arr.add(s.substring(j));
                }

            } else {
                System.out.print("/");
                for (int i=0; i< arr.size(); i++) {
                    System.out.print(arr.get(i) + "/");
                }
                System.out.println("");
            }
        }
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
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
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
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
