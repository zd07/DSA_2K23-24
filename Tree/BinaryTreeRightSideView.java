package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        queue.offer(root);
        int count=0;
        
        while(queue.size()>0){
            // TreeNode node=queue.poll();
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                map.put(count,queue.poll().val);

            }
            count++;

        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
        
    }
}
