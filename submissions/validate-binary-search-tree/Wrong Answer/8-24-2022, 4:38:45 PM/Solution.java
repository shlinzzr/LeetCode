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
        
        
        return helper(root, null, null);
        
        
    }
    
    
    private boolean helper(TreeNode root, Integer left, Integer right){
          
        if(root==null)
            return true;
        
        if(root.left!=null && root.left.val>root.val)
            return false;
        
        if(root.right!=null && root.right.val<root.val)
            return false;
        
        if(right!=null && root.val > right)
            return false;
        
        if(left!=null && root.val < left)
            return false;
        
        
        boolean bl = helper(root.left, left, root.val);
        boolean br = helper(root.right, root.val, right);
        
        
        return bl && br;
        
        
        
        
    }
}