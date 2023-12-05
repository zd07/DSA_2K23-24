package Tree;

import java.util.HashMap;

public class BinaryTreeConstructionFromPostAndIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        TreeNode root=getTree(postorder , 0 , postorder.length - 1 , inorder , 0 , inorder.length -1 , map);
        return root;
    }
    private TreeNode getTree(int[] post ,int poStart ,int poEnd , int[] in ,int inStart , int inEnd,HashMap<Integer,Integer> map){
        if(poStart > poEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(post[poEnd]);
        int inRoot = map.get(root.val);
        root.left=getTree(post , poStart , poStart + inRoot - inStart -1 , in , inStart , inRoot - 1 , map);
        root.right=getTree(post , poStart + inRoot - inStart , poEnd - 1  , in , inRoot+1 , inEnd , map);
        return root;  
    }
}
