package BinarySearchTree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node=stack.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
}
