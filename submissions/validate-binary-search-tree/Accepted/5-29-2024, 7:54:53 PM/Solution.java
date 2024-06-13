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

    private boolean helper(TreeNode node, Integer lo, Integer hi ){

        if(node==null) return true;

        // if(root.left!=null && root.left.val>=root.val) return false;
        // if(root.right!=null && root.right.val<=root.val) return false;
        // if(lo!=null && root.left!=null && root.left.val<=lo) return false;
        // if(hi!=null && root.right!=null && root.right.val>=hi) return false;

        if(lo!=null && node.val<=lo) return false;
        if(hi!=null && node.val>=hi) return false;

        boolean left = helper(node.left, lo, node.val);
        boolean right = helper(node.right, node.val, hi);

        return left && right;
    }


}