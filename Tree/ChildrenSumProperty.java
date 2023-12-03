package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperty {
    public static boolean isParentSum(TreeNode root) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++){
                TreeNode node = q.remove();
                int sum = 0;
                if(node.left != null){
                    q.add(node.left);
                    sum+=node.left.val;
                }
                if(node.right != null){
                    q.add(node.right);
                    sum+=node.right.val;
                }
                if(node.left == null && node.right == null){
                    continue;
                }
                if(sum != node.val){
                    return false;
                }
            }
        }   
        return true;
    }
}
