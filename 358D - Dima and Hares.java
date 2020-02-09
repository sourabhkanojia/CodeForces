/*For any hare except the first and last there can be three cases :

Both the adjacent hares are hungry
Both the adjacent hares are already fed
Exactly one adjacent hare is fed

So when I am at a particular hare I should know if I have fed the previous hare and 
I have to make a decision for the current one that whether it should be fed now or after the next hare.

So state would be like ( int position, bool previous )

if previous is true (previous hare is already fed) :

 1. I can feed the current hare now so result1= solve( position+1, 1)+ b[position]
 2. I will feed after the next one so  result2 =  solve( position+1, 0)+ c[position]
 

Else if previous is false (previous hare is not fed)

 1. I can feed the current hare now so result1= solve( position+1, 1)+ a[position]
 2. I will feed after the next one so  result2 =  solve( position+1, 0)+ b[position]

  return max(result1,result2)
Boundary conditions :

*Now I will call my solve function as solve(0,0) coz 1st hare has no left adjacent hare.so I assume it as hungry always

*When I am at my last hare I will take care not to feed any right adjacent hare of it. */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int[] a,b,c;
    static int[][] dp;
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a=new int[n];b=new int[n];c=new int[n];
        dp=new int[2][n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for(int i=0;i<n;i++)b[i]=sc.nextInt();
        for(int i=0;i<n;i++)c[i]=sc.nextInt();
        for(int[] i:dp)Arrays.fill(i,-1);
        System.out.println(solve(0,0));
    }
    static int solve(int position,int state){
        if(position==n-1){
            if(state==0)return a[position];
            else return b[position];
        }

        if(dp[state][position]!=-1)return dp[state][position];
        int res=0;
        if(state==0)res+=Math.max(solve(position+1,1)+a[position],solve(position+1,0)+b[position]);
        else res+=Math.max(solve(position+1,1)+b[position],solve(position+1,0)+c[position]);
        return dp[state][position]=res;
    }
}
