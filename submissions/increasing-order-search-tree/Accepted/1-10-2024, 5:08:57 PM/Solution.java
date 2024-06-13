// https://leetcode.com/problems/increasing-order-search-tree

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
    
    TreeNode dummy;
    public TreeNode increasingBST(TreeNode root) {
        // how to in-place
        // newRoot = getNewRoot(root);

        dummy = new TreeNode();
        TreeNode newRoot = dummy;
        helper(root);
        return newRoot.right;
    }

    private void helper(TreeNode root){
        if(root==null) return ;
        helper(root.left);
        root.left = null;
        dummy.right = root;
        dummy = dummy.right;
        helper(root.right);
        // dummy.right=null;
    }

    private TreeNode getNewRoot(TreeNode root){
        
        while(root.left!=null) root = root.left;
        return root;
    }
}