// https://leetcode.com/problems/house-robber-iii

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
    public int rob(TreeNode root) {

        if(root==null) return 0;

        return Math.max(doRob(root), doNotRob(root));
        
    }

    private int doRob(TreeNode root){
        if(root==null) return 0;
        return doNotRob(root.left) + root.val + doNotRob(root.right);
    }

    private int doNotRob(TreeNode root){
        if(root==null) return 0;
        return rob(root.left) + rob(root.right);
    }
}