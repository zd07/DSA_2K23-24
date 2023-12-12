package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row ,col, tm;
    Pair(int row , int col , int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
        int[][] vis=new int[n][m];
        int freshCnt=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.add(new Pair(i,j,0));
                }
                else {
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) freshCnt++;

            }
        }
        int time=0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int t=q.peek().tm;
            q.remove();
            time=Math.max(time,t);
            for(int i =0 ; i< 4 ;i++){
                int nrow= row + drow[i];
                int ncol= col + dcol[i];
                if(nrow>=0 && nrow < n && ncol>=0 && ncol < m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1 ){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(freshCnt!=cnt) return -1;
        return time;
    }
}
