package POD;

import java.util.ArrayList;


/**
 * LeafSimilarTrees
 */
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>(),list2 = new ArrayList<>();
        
        getLeaves(root1,list1);
        getLeaves(root2,list2);

        if(list1.size() != list2.size())
            return false;
        
        for(int i=0;i<list1.size();i++)
            if(list1.get(i)!=list2.get(i))
                return false;        

        return true;
    }
    public void getLeaves(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        getLeaves(root.left,list);
        getLeaves(root.right,list);
    }
}