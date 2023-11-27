package Tree;

import java.util.ArrayList;
import java.util.List;

public class TraverseBoundary {
     public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(isLeaf(root) == false) ans.add(root.val);
        addLeftBoundary(ans,root);
        addLeaves(ans,root);
        addRightBoundary(ans,root);
        return ans;
    }
    public static boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }
    public static void addLeftBoundary(List<Integer> ans, TreeNode root){
        TreeNode cur=root.left;
        while(cur!=null){
            if(!isLeaf(cur))ans.add(cur.val);
            if(cur.left != null)cur=cur.left;
            else cur=cur.right;
        }
    }
    public static void addRightBoundary(List<Integer> ans, TreeNode root){
        TreeNode cur=root.right;
        List<Integer> list=new ArrayList<>();
        while(cur!=null){
            if(!isLeaf(cur))list.add(cur.val);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        for(int i=list.size()-1;i>=0;i--){
            ans.add(list.get(i));
        }

    }
    public static void addLeaves(List<Integer> ans,TreeNode root){
        if(isLeaf(root)){
            ans.add(root.val);
            return;
        }
        if(root.left!=null) addLeaves(ans, root.left);;
        if(root.right!=null) addLeaves(ans, root.right);;
    }
}
