package BinarySearchTree;
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int value) {
        this.val = value;
        this.left = this.right = null;
    }
}
public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val!=val){
          if(root.val<val){
            root=root.right;
          }
          else{
            root=root.left;
          }
        }
        return root;
    }
}
