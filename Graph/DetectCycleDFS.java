package Graph;

import java.util.ArrayList;

public class DetectCycleDFS {
     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,adj,vis)==true)return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node]=1;
        for(int adjNode:adj.get(node)){
            if(vis[adjNode]==0){
                if(dfs(adjNode,node,adj,vis)==true) return true;
                
            }
            else if(adjNode!=parent) return true;
        }
        return false;
    }
}
