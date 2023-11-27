package Tree;

public class CorrespondingNodeInCLone {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode[] reference=new TreeNode[1];
        dfs(original, cloned, target,reference);
        return reference[0];
    }
    public void dfs(TreeNode original, TreeNode cloned, TreeNode target ,TreeNode[] reference) {
        if(original == null) return;
        if(original.val == target.val){
            reference[0] = cloned;
            return;
        }
        dfs(original.left, cloned.left, target,reference);
        dfs(original.right, cloned.right, target,reference);
    }
}
