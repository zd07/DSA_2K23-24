public class ShortestPathDAG {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Pair> temp = new ArrayList<Pair>();
            adj.add(temp);
        }

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] vis=new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                topoSort(i,adj,st,vis);
            }
        }
        int[] dis=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=1e9;
        }
        dis[0]=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).v;
                int wt=adj.get(node).get(i).wt;
                if(dis[node] + wt < dis[v]){
                    dis[v]=wt + dis[node];
                }
            }
        }
        for(int i = 0 ; i < n ; i++ ){
            if(dis[i]==1e9){
                dis[i]=-1;
            }
        }
        return dis;
    }
    private static void topoSort(int node,ArrayList<ArrayList<Pair>> adj,Stack<Integer> st,int[] vis){
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).v;
            if(vis[v]==0){
                topoSort(v,adj,st,vis);
            }
        }
        st.add(node);
    }
}
class Pair{
    int v;
    int wt;
    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }
}
