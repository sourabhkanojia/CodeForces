import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Candidate {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LinkedList<Node> ll=new LinkedList<>();
        for(int i=0;i<n;i++){
            ll.add(new Node(sc.nextInt(),sc.nextInt(),i+1));
        }
        Collections.sort(ll);
        int k=sc.nextInt();
        LinkedList<Table> table=new LinkedList<>();
        for(int i=0;i<k;i++){
            table.add(new Table(i+1,sc.nextInt()));
        }
        Collections.sort(table);

        int sum=0;
        LinkedList<Point> sol=new LinkedList<>();
        for(int i=0;i<n;i++){
           Node node=ll.removeFirst();
           int index=binarySearch(node.size,table);
           if(index==-1)continue;
           else{
               Table temp=table.remove(index);
               sum=sum+node.income;
               sol.add(new Point(node.id,temp.id));
           }
        }
        System.out.println(sol.size()+" "+sum);
        while(!sol.isEmpty()){
            Point p=sol.removeFirst();
            System.out.println(p.x+" "+p.y);
        }
    }
    public static int binarySearch(int x,LinkedList<Table>  ll){
        int l=0;
        int r=ll.size()-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(ll.get(mid).size>=x){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
class Table implements Comparable<Table>{
    int id,size;
    public Table(int id,int size){
        this.id=id;
        this.size=size;
    }
    public int compareTo(Table o){
        return this.size-o.size;
    }
}
class Node implements Comparable<Node>{
    int id,size,income;
    public Node(int size,int income,int id){
        this.size=size;
        this.income=income;
        this.id=id;
    }
    public int compareTo(Node o){
        return o.income-this.income;
    }
}
