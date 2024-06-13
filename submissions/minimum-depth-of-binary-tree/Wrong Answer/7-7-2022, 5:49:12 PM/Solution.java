// https://leetcode.com/problems/minimum-depth-of-binary-tree

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
    public int minDepth(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        
        while(q.size()>0){
            level++;
            
            TreeNode n = q.poll();
            
            if(n.left==null || n.right==null){
               break;
            }
            
            if(n.left!=null)
                q.offer(n.left);
            
            if(n.right!=null)
                q.offer(n.right);
            
        }
        
        return  (int) (Math.log(level) / Math.log(2)) +1;
    }
}