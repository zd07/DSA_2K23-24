package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
    //Using level order
    public int maxDepth(TreeNode root) {
      if (root == null) return 0;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      int maxDepth = 0;
      while (q.size() > 0) {
        maxDepth++;
        int size  = q.size();
        for (int i = 0; i < size; i++) {
          TreeNode temp = q.remove();
          if (temp.left != null) q.add(temp.left);
          if (temp.right != null) q.add(temp.right);
        }
      }
      return maxDepth;
      /* using Recursion
        if(root==null) return 0;
        int leftHeight=heightOfBinaryTroot.left);
        int rightHeight=heightOfBinaryTree(root.right);
        return 1+Math.max(leftHeight,rightHeight);
       */
    }
}

