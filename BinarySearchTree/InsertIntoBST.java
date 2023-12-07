package BinarySearchTree;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
          return new TreeNode(val);
        }
        TreeNode node=root;
        while(node!=null){
            if(node.val<val && node.right!=null){
                node=node.right;

            }
            else if(node.val>val && node.left != null){
                node=node.left;
            }
            else break;
        }
        TreeNode n = new TreeNode(val);
        if(node.val>val) node.left=n;
        else node.right=n;
        return root;
    }
}
