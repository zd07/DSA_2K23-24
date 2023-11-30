package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
class Node{
    int data;
    int hd;
    Node left,right;
    Node(int data){
        this.data=data;
        hd=Integer.MAX_VALUE;
        left=right=null;
    }
}

public class BottomView {
     public ArrayList <Integer> bottomView(Node root)
    {

        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>();
        root.hd = 0;
        q.add(root); 
        while(!q.isEmpty()) {
            Node temp = q.remove();
            int hd = temp.hd; 
            map.put(hd, temp.data); 
            if(temp.left != null) {
                temp.left.hd = hd - 1; 
                q.add(temp.left); 
            }
            if(temp.right != null) {
                temp.right.hd = hd + 1; 
                q.add(temp.right); 
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
        
    }
}
