// https://leetcode.com/problems/symmetric-tree

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
    public boolean isSymmetric(TreeNode root) {
        
        
        boolean res = true;
        if(root.left!=null || root.right!=null)
            res = res && helper(root.left, root.right);
        
        return res;
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        
        if(left==null || right==null)
            return false;
        if(left.val!=right.val)
            return false;
        
        
        boolean res=true;
        if(left.right!=null || right.left!=null)
           res = res && helper(left.right, right.left);
        
        if(left.left!=null || right.right!=null)
            res = res &&  helper(left.left, right.right);
        

        return res;
        
    }
}