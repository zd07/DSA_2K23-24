package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                ans.append("# ");
                continue;
            }
            ans.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] st = data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(st[0]));
        q.add(root);
        for(int i=1;i<st.length;i++){
            TreeNode node = q.poll();
            if(!st[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(st[i])); 
                node.left=left;
                q.add(left);  

            }
            if(!st[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(st[i])); 
                node.right=right;
                q.add(right);  

            }
        }
        return root;
    }
}
