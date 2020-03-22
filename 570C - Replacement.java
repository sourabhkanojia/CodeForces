import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt(),m=sc.nextInt();
        char[] c=sc.next().toCharArray();
        int total=0,seg=0;
        boolean z=false;
        for(int i=0;i<c.length;i++){
            if(c[i]=='.'){
                total++;
                if(!z){
                    z=true;
                    seg++;
                }
            }
            else z=false;
        }

        for(int i=0;i<m;i++){
            int index=sc.nextInt()-1;
            char x=sc.next().charAt(0);
            if(c.length==1){
                sb.append(0+"\n");
                continue;
            }
            if(x=='.' && c[index]!='.'){
                if(index==0){
                    c[0]='.';
                    if(c[1]=='.')total++;
                    else{
                        total++;
                        seg++;
                    }
                }
                else if(index==c.length-1){
                    c[index]='.';
                    if(c[index-1]=='.')total++;
                    else{
                        total++;
                        seg++;
                    }
                }
                else{
                    c[index]='.';
                    if(c[index-1]=='.' && c[index+1]=='.') seg--;
                    else if(c[index-1]!='.' && c[index+1]!='.') seg++;
                    total++;
                }
            }
            else if(x!='.' && c[index]=='.'){
                c[index]=x;
                total--;
                if(index==0){
                    if(c[index+1]!='.')seg--;
                }
                else if(index==c.length-1){
                    if(c[index-1]!='.')seg--;
                }
                else{
                    if(c[index-1]=='.' && c[index+1]=='.') seg++;
                    else if(c[index-1]!='.' && c[index+1]!='.')seg--;
                }
            }
            sb.append(total-seg+"\n");
        }
        System.out.println(sb);
    }
}
