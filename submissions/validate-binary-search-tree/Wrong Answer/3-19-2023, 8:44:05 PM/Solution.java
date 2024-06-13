// https://leetcode.com/problems/validate-binary-search-tree

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
    public boolean isValidBST(TreeNode root) {
        
       
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
    }
    
    
    private boolean helper(TreeNode root, int high, int low){
        
         if(root==null)
            return true;
        
        if(root.left!=null && (root.left.val>=root.val || root.left.val<=low))
            return false;
        
        if(root.right!=null && ( root.right.val<=root.val || root.right.val>=high))
            return false;
        
        boolean left = helper(root.left, root.val, low);
        boolean right = helper(root.right, high, root.val);
        
        return left&&right;
        
    }
    
}