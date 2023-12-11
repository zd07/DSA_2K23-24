package Graph;

import java.util.ArrayList;

public class DFSTraversal {
     public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited=new int[V];
        dfs(adj,0,visited,ans);
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int node,int[] visited,ArrayList<Integer> ans){
        visited[node]=1;
        ans.add(node);
        for(Integer it:adj.get(node)){
            if(visited[it] != 1){
                dfs(adj,it,visited,ans);
            }
        }
    }
}
