package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Definition for a binary tree node.*/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class levelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int s=queue.size();
            List<Integer> list= new LinkedList<Integer>();
            for(int i=0;i<s;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            ans.add(list);

        }
        return ans;
    }
}