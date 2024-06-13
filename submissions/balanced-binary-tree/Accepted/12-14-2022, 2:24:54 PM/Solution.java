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
        
        int left = getH(root.left, 0);
        int right = getH(root.right, 0);
        
        
        
        
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
        
      
        
    }
    
    
    private int getH(TreeNode root, int h){
        
        if(root==null)
            return h;
        
        
        return Math.max(getH(root.left, h+1), getH(root.right, h+1));
    }
}