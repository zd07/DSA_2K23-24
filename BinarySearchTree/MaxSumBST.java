package BinarySearchTree;
class NodeValue{
    int max,min,sum;
    NodeValue(int min,int max , int sum){
        this.max=max;
        this.min=min;
        this.sum=sum;
    }
}
public class MaxSumBST {
    int max = 0;
    public int maxSumBST(TreeNode root) {
        largestBSTHelper(root);
        return max;
    }
    private  NodeValue largestBSTHelper(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE, 0);
        }
        NodeValue left=largestBSTHelper(root.left);
        NodeValue right=largestBSTHelper(root.right);
        if(left.max < root.val && root.val < right.min){
            max =  Math.max(max,left.sum + right.sum + root.val);
            return new NodeValue(Math.min(root.val,left.min), Math.max(root.val,right.max),left.sum + right.sum + root.val);
        }
        else {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum,right.sum));
        }
    }
}
