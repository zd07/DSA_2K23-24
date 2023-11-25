package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BinaryTreeInOrderTraversal {
    public static List<Integer> iterativeInOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            // Traverse left as far as possible
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Visit the current node
            root = stack.pop();
            result.add(root.value);

            // Move to the right subtree
            root = root.right;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = iterativeInOrderTraversal(root);
        System.out.println(result);  // Output: [4, 2, 5, 1, 3]
    }
}
