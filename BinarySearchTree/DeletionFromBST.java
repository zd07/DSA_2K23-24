package BinarySearchTree;

public class DeletionFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            return helper(root);
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val < key) {
                if (node.right != null && node.right.val == key) {
                    node.right = helper(node.right);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left != null && node.left.val == key) {
                    node.left = helper(node.left);
                    break;

                } else {
                    node = node.left;
                }
            }
        }
        return root;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    private TreeNode findLastRight(TreeNode root) {
        if (root.right == null)
            return root;
        return findLastRight(root.right);
    }
}
