package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortKahnBFS {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<v; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i =0; i<e; i++){
            adjlist.get(edges[i][0]).add(edges[i][1]);
        }
        int[] indegree = new int[v];
        for(int i=0;i <v; i++){
            for(int it : adjlist.get(i)){
                indegree[it]++;
            }
        }
        for(int i =0 ; i < v;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);
            for(int it:adjlist.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return ans; 
    }
}
