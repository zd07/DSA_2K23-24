package Tree;

public class HeightBalancedCheck {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftHeight=helper(root.left);
        if(leftHeight==-1) return -1;
        int rightHeight=helper(root.right);
        if(rightHeight==-1) return -1;
        if(Math.abs(leftHeight-rightHeight) > 1)return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
