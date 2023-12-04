package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToBurnTree {
    public static int timeToBurnTree(TreeNode root, int start)
    {
        // Write your code here.
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        TreeNode target =toMapParent(root,map,start);
        int ans=findMax(map,target);
		return ans;
    }
    private static TreeNode toMapParent(TreeNode root,HashMap<TreeNode,TreeNode> map ,int start){
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode res = new TreeNode(-1);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			if(node.data==start) res = node;
			if(node.left!=null){
				map.put(node.left,node);
				q.add(node.left);
			}
			if(node.right!=null){
				map.put(node.right,node);
				q.add(node.right);
			}
		}
		return res;
	}
	private static int findMax(HashMap<TreeNode,TreeNode> map,TreeNode target){
		Queue<TreeNode> q = new LinkedList<>();
		q.add(target);
		HashMap<TreeNode,Integer> vis = new HashMap<>();
		vis.put(target,1);
		int max=0;
		while(!q.isEmpty()){
			int n=q.size();
			int flag=0;
			for(int i=0;i<n;i++){
				TreeNode node = q.poll();
				if(node.left!=null && vis.get(node.left)==null){
					flag=1;
					vis.put(node.left,1);
					q.add(node.left);
				}
				if(node.right!=null && vis.get(node.right)==null){
					flag=1;
					vis.put(node.right,1);
					q.add(node.right);
				}
				if(map.get(node)!=null && vis.get(map.get(node))==null){
					flag=1;
					vis.put(map.get(node),1);
					q.add(map.get(node));
				}
				
			}
			if(flag==1) max++;
			
		}
		return max;
	}
}
