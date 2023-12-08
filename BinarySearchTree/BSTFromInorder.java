package BinarySearchTree;

public class BSTFromInorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] idx=new int[1];
        idx[0]=0;
        return bstFromPreorder(preorder,Integer.MAX_VALUE,idx);
    }
    public TreeNode bstFromPreorder(int[] pre ,int maxVal,int[] idx){
        if(idx[0]==pre.length || pre[idx[0]]>maxVal) return null;
        TreeNode node=new TreeNode(pre[idx[0]++]);
        node.left=bstFromPreorder(pre,node.val,idx);
        node.right=bstFromPreorder(pre,maxVal,idx);
        return node;
    }
}
