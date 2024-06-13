// https://leetcode.com/problems/house-robber-iii

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
    int max =0; 
    public int rob(TreeNode root) {
        
        return Math.max(helper(root, true), helper(root, false));
        
        
        
        
    }
    
    private int helper(TreeNode root, boolean stole){
        
        if(root==null)
            return 0;
        
        
        if(stole==true)
            return helper(root.left, false) + helper(root.right, false);
        
        else
            return Math.max( helper(root.left, false) + helper(root.right, false),
                             root.val + helper(root.left, true) + helper(root.right, true));
        
        
            
        
        
        
            
        
        
    }
}