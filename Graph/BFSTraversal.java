package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
     public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        List<Integer> ans=new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            for(int it:adj.get(node)){
                if(visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return ans;
    }
}
