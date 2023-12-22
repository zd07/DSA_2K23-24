package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SingleSourceShortestPath {
    public static int[] shortestPath(int n, int[][] edges, int src) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);

        }
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dis[src] = 0;
        while (q.size() > 0) {
            int node = q.remove();
            for (Integer it : adj.get(node)) {
                if (dis[node] + 1 < dis[it]) {
                    dis[it] = dis[node] + 1;
                    q.add(it);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                dis[i] = -1;
        }
        return dis;
    }
}
