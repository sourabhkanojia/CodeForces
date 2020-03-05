import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mod=(int)1e9+7;
    static char[][] c;
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        n=sc.nextInt();
        Point[][] p=new Point[n][n];
        c=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                p[i][j]=new Point(sc.nextInt()-1,sc.nextInt()-1);
                if(p[i][j].x==-2){
                    p[i][j].x=-1;
                    p[i][j].y=-1;
                }
                if(p[i][j].x==i && p[i][j].y==j){
                    c[i][j]='X';
                }
                else c[i][j]='.';
            }
        }
        boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(c[i][j]=='X'){
                    LinkedList<Point> queue=new LinkedList<>();
                    queue.add(new Point(i,j));
                    vis[i][j]=true;
                    while(!queue.isEmpty()){
                        Point e=queue.removeFirst();
                        int x=e.x,y=e.y;
                        if(x+1<n && !vis[x+1][y] && p[x+1][y].x==i && p[x+1][y].y==j){
                            c[x+1][y]='U';
                            vis[x+1][y]=true;
                            queue.add(new Point(x+1,y));
                        }
                        if(x-1>=0 && !vis[x-1][y] && p[x-1][y].x==i && p[x-1][y].y==j){
                            c[x-1][y]='D';
                            vis[x-1][y]=true;
                            queue.add(new Point(x-1,y));
                        }
                        if(y+1<n && !vis[x][y+1] && p[x][y+1].x==i && p[x][y+1].y==j){
                            c[x][y+1]='L';
                            vis[x][y+1]=true;
                            queue.add(new Point(x,y+1));
                        }
                        if(y-1>=0 && !vis[x][y-1] && p[x][y-1].x==i && p[x][y-1].y==j){
                            c[x][y-1]='R';
                            vis[x][y-1]=true;
                            queue.add(new Point(x,y-1));
                        }
                    }
                }
            }
        }

        boolean z=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(p[i][j].x!=-1){
                    if(c[i][j]=='.'){
                        z=true;
                        break;
                    }
                }
            }
            if(z)break;
        }
        if(z){
            System.out.println("INVALID");
            return;
        }
        visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(c[i][j]=='.')bfs(i,j);
            }
        }

        z=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(c[i][j]=='.'){
                    z=true;
                    break;
                }
            }
            if(z)break;
        }
        if(z){
            System.out.println("INVALID");
            return;
        }
        System.out.println("VALID");
        for(int i=0;i<n;i++) System.out.println(c[i]);
    }
    static void bfs(int x,int y){
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(new Node(x,y,'.'));
        visited[x][y]=true;
        while(!queue.isEmpty()){
            Node e=queue.removeFirst();
            boolean z=false;
            if(e.i+1<n && c[e.i+1][e.j]=='.' && !visited[e.i+1][e.j]){
                c[e.i][e.j]='D';
                visited[e.i+1][e.j]=true;
                z=true;
                queue.add(new Node(e.i+1,e.j,'U'));
            }
            if(e.i-1>=0 && c[e.i-1][e.j]=='.' && !visited[e.i-1][e.j]){
                c[e.i][e.j]='U';
                visited[e.i-1][e.j]=true;
                z=true;
                queue.add(new Node(e.i-1,e.j,'D'));
            }
            if(e.j+1<n && c[e.i][e.j+1]=='.' && !visited[e.i][e.j+1]){
                c[e.i][e.j]='R';
                visited[e.i][e.j+1]=true;
                z=true;
                queue.add(new Node(e.i,e.j+1,'L'));
            }
            if(e.j-1>=0 && c[e.i][e.j-1]=='.' && !visited[e.i][e.j-1]){
                c[e.i][e.j]='L';
                visited[e.i][e.j-1]=true;
                z=true;
                queue.add(new Node(e.i,e.j-1,'R'));
            }
            if(!z)c[e.i][e.j]=e.c;
        }
    }
}
class Node{
    int i,j;
    char c;
    public Node(int i,int j,char c){
        this.i=i;
        this.j=j;
        this.c=c;
    }
}
