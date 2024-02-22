// https://leetcode.com/problems/sum-root-to-leaf-numbers

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
    public int sumNumbers(TreeNode root) {
        
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int curr){
        
        if(root==null)
            return curr;
        
        curr=curr*10+ root.val;
        
        if(root.left==null && root.right==null)
            return curr;
        
        int left = root.left==null? 0 : helper(root.left, curr);
        int right = root.right==null ? 0 :helper(root.right, curr);
        
        return left+right;
        
        
        
        
    }
}