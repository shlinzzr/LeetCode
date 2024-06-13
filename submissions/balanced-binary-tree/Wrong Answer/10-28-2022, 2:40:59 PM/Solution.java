// https://leetcode.com/problems/balanced-binary-tree

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
    public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;
        
        if(root.left==null && root.right!=null && (root.right.left!=null || root.right.right!=null)
         || root.right==null && root.left!=null && (root.left.right!=null || root.left.left!=null))
            return false;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        return left&&right;
        
    }
    
}