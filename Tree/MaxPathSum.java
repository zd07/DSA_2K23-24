package Tree;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if(root!=null && root.left==null && root.right==null) return root.val;
        int[] sum=new int[1];
        sum[0]=Integer.MIN_VALUE;
        height(root,sum);
        return sum[0];
    }
    public int height(TreeNode root,int[] sum){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,height(root.left,sum));
        int right=Math.max(0,height(root.right,sum));
        sum[0]=Math.max(sum[0],left+right + root.val);
        return Math.max(left,right)+root.val;

    }
}
