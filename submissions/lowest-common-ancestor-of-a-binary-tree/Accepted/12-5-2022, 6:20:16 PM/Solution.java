// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //https://www.youtube.com/watch?v=13m9ZCB8gjw
        
        if(root==p || root==q || root==null)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left!=null && right!=null)
            return root;
        
        if(left==null && right==null)
            return null;
        
         return left == null ? right : left;
        
        
        
    }
}