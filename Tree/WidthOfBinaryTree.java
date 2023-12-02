package Tree;

import java.util.LinkedList;
import java.util.Queue;
 class Pair{
     TreeNode node;
     int idx;
     Pair(TreeNode node, int idx){
         this.node=node;
         this.idx=idx;
     }
 }
public class WidthOfBinaryTree {
     public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            int min=queue.peek().idx;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int id=queue.peek().idx-min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0)first=id;
                if(i==size-1)last=id;
                if(node.left!=null){
                    queue.offer(new Pair(node.left,id*2+1));
                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,id*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
