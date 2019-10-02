import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class problems {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long sol=0;
        for(int i=2;i<n;i++){
            sol=sol+i*(i+1);
        }
        System.out.println(sol);
    }
}

//Every triangle should contain vertex 1. Then the answer will be minimum.
