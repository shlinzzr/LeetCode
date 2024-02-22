// https://leetcode.com/problems/check-completeness-of-a-binary-tree

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

    int max = 0;
    public boolean isCompleteTree(TreeNode root) {


        getMax(root, 0);
        return helper(root, 0);
    }

    private void getMax(TreeNode root, int idx){

        if(root==null) return;

        max = Math.max(max, idx);

        helper(root.left, 2*idx+1);
        helper(root.right, 2*idx+2);

    }

    private boolean helper(TreeNode root, int idx){

        if(root==null && idx<max) return false; 
        if(root==null) return true;

        max = Math.max(max, idx);

        boolean left = helper(root.left, 2*idx+1);
        boolean right = helper(root.right, 2*idx+2);

        return left && right;

    }
}