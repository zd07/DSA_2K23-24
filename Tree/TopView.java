package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
public class TopView {
    static ArrayList<Integer> topView(TreeNode root) {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while (queue.size() > 0) {
            Pair temp = queue.poll();
            int x = temp.col;
            TreeNode node = temp.node;
            if (map.get(x) == null) {
                map.put(x, node.val);
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, x - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, x + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }
}

class Pair {
    TreeNode node;
    int col;

    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
