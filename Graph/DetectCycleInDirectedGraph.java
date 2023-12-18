package Graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);    
        }
        int vis[] = new int[v];
        int recStack[] = new int[v];
        for(int i = 0;i<v;i++){
           if(vis[i]==0){
               if(dfs(i,adj,vis,recStack))
               return true;
           } 
        }
        return false;
	}
    public static Boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int recStack[]){
        vis[node] = 1;
        recStack[node] = 1;
        for(int i:adj.get(node))
        {
            if(vis[i]==0)
            {
                if(dfs(i,adj,vis,recStack))
                    return true;
            }
            else if(recStack[i]==1)
            return true;
        }
        recStack[node] = 0;
        return false;
    }
}
