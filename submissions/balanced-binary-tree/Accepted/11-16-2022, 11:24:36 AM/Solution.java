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
        
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        
        int left = getH(root.left);
        int right = getH(root.right);
        
        // System.out.println(left + " " +right);
        // System.out.println(l + " " +r);
        
        
        return Math.abs(left-right)<=1 && l && r;
        
        
        
    }
    
    
    private int getH(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left = getH(root.left);
        int right = getH(root.right);
        
        return Math.max(left, right)+1;        
    }
}