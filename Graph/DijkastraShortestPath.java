import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Pair{
  int v,wt;
  Pair(int v,int wt){
    this.v=v;
    this.wt=wt;
  }
}
public class DijkastraShortestPath {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // Write your code here.
       List<List<Pair>> l=new ArrayList<>();
       Queue<Pair> pq=new PriorityQueue<>((x,y)->x.wt-y.wt);
       pq.add(new Pair(source,0));
       for(int i=0;i<vertices;i++){
       List<Pair> tem=new ArrayList<>();
           l.add(tem);
       }
       for(int i=0;i<edge.length;i++){
         int a=edge[i][0];
         int b=edge[i][1],c=edge[i][2];
         l.get(a).add(new Pair(b,c));
         l.get(b).add(new Pair(a,c));
       }
       int dis[]=new int[vertices];
       Arrays.fill(dis,Integer.MAX_VALUE);
       dis[source]=0;
       while(!pq.isEmpty()){
        Pair p=pq.poll();
        for(Pair curr:l.get(p.v)){
         if(p.wt+curr.wt<dis[curr.v]){
          dis[curr.v]=p.wt+curr.wt;
          pq.add(new Pair(curr.v,dis[curr.v]));
             
           }
         }
       }
       List<Integer> ans=new ArrayList<>();
       for(int i:dis) ans.add(i);
       return ans;
    }
}
