package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Pair{
            int node;
            int parent;
            Pair(int node,int parent){
                this.node=node;
                this.parent=parent;
            }
        }
public class DetectCycleInUndirectedGraph {
    boolean detectCycle(int V, List<List<Integer>> adj) {
            // Write your code here.
            boolean[] vis=new boolean[V];
            for(int i = 0 ; i < V ; i++) vis[i]=false;
            for(int i = 0 ; i < V ; i++){
                if(vis[i]==false){
                    boolean cycle=bfs(i,adj,vis);
                    if(cycle) return true;
                }
            }
            return false;
        }
        boolean bfs(int i , List<List<Integer>> adj , boolean[] vis){
            Queue<Pair> q = new LinkedList<>();
            vis[i] = true;
            q.add(new Pair(i,-1));
            while(!q.isEmpty()){
                int node=q.peek().node;
                int parent=q.peek().parent;
                q.remove();
                for(int adjNode:adj.get(node)){
                    if(vis[adjNode]==false){
                        vis[adjNode]=true;
                        q.add(new Pair(adjNode, node));
                    }
                    else if(parent != adjNode)return true;
                }
            }
            return false;
        }
}
