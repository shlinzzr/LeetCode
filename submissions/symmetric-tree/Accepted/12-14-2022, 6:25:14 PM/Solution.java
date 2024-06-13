// https://leetcode.com/problems/symmetric-tree

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        
        if(root.left==null && root.right==null)
            return true;
        
        if(root.left==null || root.right==null)
            return false;
        
        if(root.left.val!=root.right.val){
            return false;
        }
        
        return helper(root.left, root.right);
        
        
    }
    
    private boolean helper(TreeNode p, TreeNode q){
        if(p==null && q==null)
            return true;
        
        if(p==null || q==null)
            return false;
        
        if(p.val!=q.val)
            return false;
        
        return helper(p.left, q.right) && helper(p.right, q.left);
        
        
    }
}