import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n=sc.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++)str[i]=sc.next();
        for(int i=0;i<n;i++) {
            if (str[i].contains("R") && str[i].contains("C") && str[i].charAt(str[i].indexOf("R") + 1) >= '0' && str[i].charAt(str[i].indexOf("R") + 1) <= '9'
                    && str[i].charAt(str[i].indexOf("C") + 1) >= '0' && str[i].charAt(str[i].indexOf("C") + 1) <= '9') {
                String left = str[i].split("C")[0];
                String row = left.split("R")[1];
                String col = str[i].split("C")[1];
                int tcol = Integer.valueOf(col);
                col = "";
                while (tcol > 0) {
                    col += (char) (tcol % 26 + 64);
                    if (tcol % 26 == 0) {
                        tcol = (tcol - 1) / 26;
                    } else {
                        tcol = tcol / 26;
                    }
                }
                String column = "";
                for (int j = col.length() - 1; j >= 0; j--) {
                    if (col.charAt(j) == '@') {
                        column += "Z";
                    } else {
                        column += col.charAt(j);

                    }
                }

                sb.append(column + "" + row + "\n");

            } else {
                int j = 0;
                int col = 0;
                String row = "";
                while (str[i].charAt(j) > '9') {
                    col += (str[i].charAt(j) - 64);
                    if (str[i].charAt(j+ 1) <= '9') {
                        for (j = j + 1; j < str[i].length(); j++) {
                            row += str[i].charAt(j);
                        }
                        break;
                    }
                    col = col * 26;
                    ++j;
                }
                sb.append("R" + row + "C" + col + "\n");
            }
        }
        System.out.println(sb);
    }
}
