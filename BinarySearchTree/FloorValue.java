package BinarySearchTree;

public class FloorValue {
    public static int Floor(TreeNode node, int input) {
		int ans = -1;
		while(node!=null){
			if(node.val==input){
				return input;
			}
			if(node.val<input){
				ans=node.val;
				node=node.right;
			}
			else{
				node=node.left;
			}
		}
		return ans;
	}
}
