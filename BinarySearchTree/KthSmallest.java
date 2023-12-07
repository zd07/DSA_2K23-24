package BinarySearchTree;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {

        // List<Integer> list = new ArrayList<>();
        if(root==null) return 0;
        int ans[] = new int[1];
        int[] kth=new int[1];
        kth[0]=k;
        inorder(root,ans,kth);
        return ans[0];

    }
    public void inorder(TreeNode root,int[] ans,int k[]){
        if(root==null)return;
        inorder(root.left,ans,k);
        k[0]--;
        if(k[0]==0){
          ans[0]=root.val;
        }
        inorder(root.right,ans,k);
    }
}
