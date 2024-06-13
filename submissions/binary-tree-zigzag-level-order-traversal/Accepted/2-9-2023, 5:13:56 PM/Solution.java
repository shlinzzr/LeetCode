// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean front = false;
        int lv =1;
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                
                if(res.size()<lv)
                    res.add(new ArrayList<>());
                
                TreeNode p = q.poll();
                if(front){
                    res.get(lv-1).add(0, p.val);    
                }else{
                    res.get(lv-1).add(p.val);
                }
                
                
                if(p.left!=null)
                    q.offer(p.left);
                
                if(p.right!=null)
                    q.offer(p.right);
            }
            lv++;
            front=!front;
        }
        
        return res;
        
    }
}