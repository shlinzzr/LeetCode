// https://leetcode.com/problems/diameter-of-binary-tree

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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null)
            return 0;
        
        return getH(root.left) + getH(root.right);
            
    }
    
    private int getH(TreeNode root){
        if(root==null)
            return 0;
        
        int left = getH(root.left);
        int right = getH(root.right);
        
        return Math.max(left,right)+1;
    }
}