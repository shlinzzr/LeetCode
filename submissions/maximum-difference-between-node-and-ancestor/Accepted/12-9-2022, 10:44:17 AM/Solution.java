// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

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
    
    int res;
    public int maxAncestorDiff(TreeNode root) {
        
        res =0;
        
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return res;
    }
    
    
    private void helper(TreeNode root, int max, int min){
        
        if(root==null)
            return;

        
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        
        res = Math.max(res, max-min);
        
        if(root.left!=null){
            helper(root.left, max, min);
        }
        
        if(root.right!=null){
            helper(root.right, max, min);
        }
        
        
        
    }
        
}