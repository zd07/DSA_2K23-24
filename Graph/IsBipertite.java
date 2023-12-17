package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipertite {
    public boolean isBipartite(int[][] graph) {
         int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                // if(checkUsingBfs(i, graph, color) == false) return false;
                if(checkUsingDfs(i, 0, graph, color) == false) return false;
            }
        }
        return true;
    }
     private boolean checkUsingDfs(int node, int col, int[][] graph, int[] color){
        color[node] = col; // color the node with given color.

        // check for the adjacent nodes 

        for(Integer it : graph[node]){

        //if the node is not colored
        // color with the opposite color
            if(color[it] == -1){
                if(checkUsingDfs(it, 1-col, graph, color) == false) return false;
            }
            // if the color is same then return false
            else if(color[it] == col) return false;
        }
        return true;
    }
    private boolean checkUsingBfs(int start, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start); 
        color[start] = 0;

        
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer it : graph[node]){
                if(color[it] == -1){
               
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                 //if adj node has same color as that of curr node
                // someone already colored before
                else if(color[it] == color[node]) return false;
            }
        }
        return true;
    }
}
