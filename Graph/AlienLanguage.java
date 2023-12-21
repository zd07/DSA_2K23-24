package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienLanguage {
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        int n=dictionary.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            String s1=dictionary[i];
            String s2=dictionary[i+1];
            int size = Math.min(s1.length(), s2.length());
            for(int j=0;j<size;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> list = topoSort(k,adj);
        String ans="";
        for(int it:list){
            ans+=(char)(it+(int)('a'));
        }
        return ans;
    }
    private static List<Integer> topoSort(int V,List<List<Integer>> adj){
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node =q.remove();
            topo.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
