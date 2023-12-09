
package BinarySearchTree;
import java.util.Stack;

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator left= new BSTIterator(root,false); 
        BSTIterator right=new BSTIterator(root,true);
        int i=left.next();
        int j=right.next();
        while(i<j){
            if(i+j==k){
                return true;
            }
            else if(i+j < k) i = left.next();
            else j=right.next();
        }
        return false;
 
     }
 }
 class BSTIterator{
     Stack<TreeNode> stack=new Stack<TreeNode>();
     boolean reverse=true;
     BSTIterator(TreeNode root,boolean isReverse){
         reverse=isReverse;
         pushAll(root);
     }
     public int next(){
         TreeNode node=stack.pop();
         if(!reverse) pushAll(node.right);
         else pushAll(node.left);
         return node.val;
     }
     public boolean hasNext(){
         return !stack.isEmpty();
     }
     private void pushAll(TreeNode root){
          
         while(root!=null){
             stack.push(root);
             if(reverse) root=root.right;
             else root=root.left;
         }
     }
 }
