package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesInTree {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }
                q.poll();
                count++;
            }
        }
        return count;
    }
}
