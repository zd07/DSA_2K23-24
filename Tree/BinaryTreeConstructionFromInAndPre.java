package Tree;

import java.util.HashMap;

public class BinaryTreeConstructionFromInAndPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        TreeNode root=getTree(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length -1 , map);
        return root;
    }
    private TreeNode getTree(int[] pre ,int preStart ,int preEnd , int[] in ,int inStart , int inEnd,HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft= inRoot -inStart;
        root.left=getTree(pre , preStart + 1 , preStart + numsLeft , in , inStart , inRoot - 1 , map);
        root.right=getTree(pre , preStart + numsLeft + 1 , preEnd  , in , inRoot+1 , inEnd , map);
        return root;
    }
}
