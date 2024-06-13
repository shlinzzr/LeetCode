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

    private boolean helper(TreeNode node , Integer lower, Integer higher){

        if(node==null) return true;

        if(lower!=null && node.val<=lower) return false;
        if(higher!=null && node.val>=higher) return false;

        boolean left = helper(node.left, lower, node.val);
        boolean right = helper(node.right, node.val, higher);

        return left && right;


    }

}