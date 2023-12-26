package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Pair{
    int v;
    int wt;
    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }
}
class Tuple{
    int stops;
    int nodes;
    int cost;
    Tuple(int stops,int nodes,int cost){
        this.stops=stops;
        this.nodes=nodes;
        this.cost=cost;
    }
}

public class ChipestFlightsWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m=flights.length;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int[] dist =new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple it=q.remove();
            int stop=it.stops;
            int node=it.nodes;
            int cost=it.cost;
            if(stop>k) continue;
            for(Pair i:adj.get(node)){
                int v=i.v;
                int edW=i.wt;
                if(cost + edW <dist[v] && stop<=k){
                    dist[v]=cost+edW;
                    q.add(new Tuple(stop + 1 , v , cost+ edW));
                }
            }
        }
        if(dist[dst]==(int)1e9) return -1;
        return dist[dst];
    }
}
