package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return 0;
        }
        queue.offer(root);
        int count=1;
        while(queue.size()>0){
            int size=queue.size();
            // List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                if(temp.left == null && temp.right == null ){
                    return count;
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            count++;
        }
        return count;
    }
}
