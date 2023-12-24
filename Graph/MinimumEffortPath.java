package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
class Tuple{
    int dist;
    int row;
    int col;
    Tuple(int dist,int row,int col){
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}
public class MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist=new int[m][n];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.dist - y.dist);
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        
        
        while(!pq.isEmpty()){
            Tuple it=pq.poll();
            int diff=it.dist;
            int row=it.row;
            int col=it.col;
            if(row==m-1 && col==n-1) return diff;
            for(int i=0;i<4;i++){
                int nrow= row + drow[i];
                int ncol= col + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(effort < dist[nrow][ncol]){
                        dist[nrow][ncol]=effort;
                        pq.add(new Tuple(effort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}
