// https://leetcode.com/problems/path-sum-iii

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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        
        
        return (int)helper(root, (long)targetSum) 
            + pathSum(root.left, targetSum) 
            + pathSum(root.right, targetSum);
    }
    
    private int helper(TreeNode root, long targetSum){
        
        if(root==null)
            return 0;
        
        return (root.val==targetSum ? 1 :0 )
            + helper(root.left, targetSum-root.val) 
            + helper(root.right, targetSum-root.val);
        
    }
}