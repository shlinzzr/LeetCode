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
        
        if(root==null)
            return true;
        
        if(root.left==null || root.right==null){
            if(root.left!=null || root.right!=null){
                return false;
            }
        }
        
        if(root.left!=null || root.right!=null){
            
            if(root.left==null || root.right==null || (root.left.val!=root.right.val)){
                return false;
            }
            
            boolean left_sub = isSymmetric(root.left);
            boolean right_sub = isSymmetric(root.right);
            
            return left_sub && right_sub;
            
        }
        
        return true;
        
        
    }
}