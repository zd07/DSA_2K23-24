package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvantualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[] indegree=new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
/*
 * class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; 
        // 0 = not visited, 
        // 1 = visited and safe, 
        //-1 = visited and not safe, 
        // 2 = currently visiting
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            boolean check = dfs(graph, visited, i);
            if(check)
                result.add(i);
        }
        return result;
    }
    public boolean dfs(int[][] graph, int[] visited, int node){
        if(visited[node] == 2 || visited[node] == -1){
            return false;
        }
        if(visited[node] == 1){
            return true;
        }
        visited[node] = 2;
        for(int next : graph[node]){
            boolean check = dfs(graph, visited, next);
            if(!check){
                visited[node] = -1;
                return false;
            }
        }
        visited[node] = 1;
        return true;
    }
}
 */
