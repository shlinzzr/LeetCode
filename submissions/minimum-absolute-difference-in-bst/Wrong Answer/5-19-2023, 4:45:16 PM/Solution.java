// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    
    int min = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        
        if(root==null)
            return min;
        
        if(root.left!=null){
            min = Math.min(min, Math.abs(root.val-root.left.val));
            getMinimumDifference(root.left);
        }
        
        if(root.right!=null){
            min = Math.min(min, Math.abs(root.val-root.right.val));
            getMinimumDifference(root.right);
        }
        
        
        return min;
    }
}