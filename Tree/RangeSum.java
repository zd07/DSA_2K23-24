package Tree;

public class RangeSum {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] res= new int[1];
        sum(root,low,high,res);
        return res[0];
    }
    public void sum(TreeNode root, int low , int high,int[] res){
        if(root==null){
            return;
        }
        if(low<=root.val && root.val<=high) res[0]+=root.val;
        sum(root.left,low,high,res);
        sum(root.right,low,high,res);
    }
}
