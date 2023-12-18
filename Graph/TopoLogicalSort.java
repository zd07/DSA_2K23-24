package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopoLogicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,stack);
            }
        }
        int[] ans=new int[V];
        for(int i=0;i<V;i++){
            ans[i]=stack.pop();
        }
        return ans;
    }
    private static void dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] vis , Stack<Integer> stack){
        vis[i]=1;
        for(int it:adj.get(i)){
            if(vis[it]==0){
                dfs(it,adj,vis,stack);
            }
        }
        stack.push(i);
    }
}
