package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] { root1, root2 });
        while (!queue.isEmpty()) {
            TreeNode[] node = queue.poll();
            node[0].val += node[1].val;

            if (node[0].left != null || node[1].left != null) {
                if (node[0].left != null && node[1].left != null) {
                    queue.offer(new TreeNode[] { node[0].left, node[1].left });
                } else if (node[0].left == null) {
                    node[0].left = node[1].left;
                }
            }

            if (node[0].right != null || node[1].right != null) {
                if (node[0].right != null && node[1].right != null) {
                    queue.offer(new TreeNode[] { node[0].right, node[1].right });
                } else if (node[0].right == null) {
                    node[0].right = node[1].right;
                }
            }
        }

        return root1;

    }
}
/*
 * public static TreeNode mergeTrees_bfs(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
		
        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.left != null || node2.left != null) {
                if (node1.left != null && node2.left != null) {
                    TreeNode leftNode = new TreeNode(node1.left.val + node2.left.val);
                    node.left = leftNode;
                    queue.offer(leftNode);
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                } else if (node1.left != null) {
                    node.left = node1.left;
                } else if (node2.left != null) {
                    node.left = node2.left;
                }
            }

            if (node1.right != null || node2.right != null) {
                if (node1.right != null && node2.right != null) {
                    TreeNode rightNode = new TreeNode(node1.right.val + node2.right.val);
                    node.right = rightNode;
                    queue.offer(rightNode);
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                } else if (node1.right != null) {
                    node.right = node1.right;
                } else if (node2.right != null) {
                    node.right = node2.right;
                }
            }
        }

        return merged;
    }
The BFS code is not neat, I have refactor it.

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root1, root2});
        while (!queue.isEmpty()) {
            TreeNode[] node = queue.poll();
            node[0].val += node[1].val;

            if (node[0].left != null || node[1].left != null) {
                if (node[0].left != null && node[1].left != null) {
                    queue.offer(new TreeNode[]{node[0].left, node[1].left});
                } else if (node[0].left == null) {
                    node[0].left = node[1].left;
                }
            }

            if (node[0].right != null || node[1].right != null) {
                if (node[0].right != null && node[1].right != null) {
                    queue.offer(new TreeNode[]{node[0].right, node[1].right});
                } else if (node[0].right == null) {
                    node[0].right = node[1].right;
                }
            }
        }

        return root1;
    }
 */
