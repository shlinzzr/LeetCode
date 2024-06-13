// https://leetcode.com/problems/construct-string-from-binary-tree

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
    
    
    public String tree2str(TreeNode root) {
        String res ="";    
        return helper(root, res);
        
    }
    
    private String helper(TreeNode root, String res){
        
        if(root==null)
            return null;
        
        String left = helper(root.left, res);
        String right = helper(root.right, res);
        
        if(right!=null && left==null)
            left="";
        
        
        res += root.val + (left==null? "" : "(" + left + ")" ) + (right==null? "" : "(" + right + ")") ;
        
        return res;
    }
}