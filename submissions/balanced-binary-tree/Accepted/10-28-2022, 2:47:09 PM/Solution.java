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
        
        int h= getH(root);
        if(h==-1)
            return false;
        return true;
        
    }
    
    private int getH(TreeNode root){
        if(root==null)
            return 0;
        
        int left = getH(root.left);
        if(left==-1)
            return -1;
            
        int right = getH(root.right);
        if(right==-1)
            return -1;
        
        if(Math.abs(left-right)>1)
            return -1;
        
        return Math.max(left, right)+1;
    }
    
}