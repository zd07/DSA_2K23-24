package BinarySearchTree;

public class CeilValue {
    public  static int findCeil(TreeNode node, int x) {

        // Write your code here
        int ans=-1;
        while(node!=null){
            if(node.val==x)return x;
            if(x>node.val){
                node=node.right;
            }
            else{
                ans=node.val;
                node=node.left;
            }
        }
        return ans;
       // return
    }
}
