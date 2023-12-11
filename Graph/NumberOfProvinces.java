package Graph;

public class NumberOfProvinces {
    public static void dfs(int i,int vis[],int arr[][]){
        for(int j = 0;j<arr.length;j++){
            if(arr[i][j]==1&&vis[j]==0){
                vis[j] = 1;
                dfs(j,vis,arr);
            }
        }
    }
    public static int findNumOfProvinces(int[][] roads, int n) {
        int count = 0;
        int vis[] = new int[n];
        for(int i = 0 ;i<n;i++)
        {
            if(vis[i]==0)
            {
                count++;
                dfs(i,vis,roads);
            }
        }
        return count;
    }
}
