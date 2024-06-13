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
        if(root==null) return true;

        return helper(root, null, null);
        
    }

    private boolean helper(TreeNode root, Integer lo, Integer hi ){

        if(root==null) return true;

        if(lo!=null && root.left!=null && root.left.val<lo) return false;
        if(hi!=null && root.right!=null && root.right.val>hi) return false;

        boolean left = helper(root.left, lo, root.val);
        boolean right = helper(root.right, root.val, hi);

        return left && right;
    }


}