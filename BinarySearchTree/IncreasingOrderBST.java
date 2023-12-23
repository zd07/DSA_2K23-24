package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IncreasingOrderBST {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode target = result;
        List<Integer> tmpResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();

            result.right = new TreeNode(top.val);
            result.left = null;
            result = result.right;

            root = top.right;
        }
        for (Integer i: tmpResult) {
            result.right = new TreeNode(i);
            result.left = null;
            result = result.right;
        }
        return target.right;
    }
}
/*
 * public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode target = result;
        List<Integer> tmpResult = new ArrayList<>();

        traverseInOrder(root, tmpResult);

        for (Integer i: tmpResult) {
            result.right = new TreeNode(i);
            result.left = null;
            result = result.right;
        }
        return target.right;
    }

    public void traverseInOrder(TreeNode root, List<Integer> tmpResult) {
        if (root != null) {
            traverseInOrder(root.left, tmpResult);
            tmpResult.add(root.val);
            traverseInOrder(root.right, tmpResult);
        }
    }
 */
