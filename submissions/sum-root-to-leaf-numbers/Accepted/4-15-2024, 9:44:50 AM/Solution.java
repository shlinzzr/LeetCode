// https://leetcode.com/problems/sum-root-to-leaf-numbers

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

    int res= 0 ;
    public int sumNumbers(TreeNode root) {

        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int val){
        if(node==null) return;
        val = val*10 + node.val;
        if(node.left==null && node.right==null){
            res+=val;
            return;
        }

        helper(node.left, val);
        helper(node.right, val);
    }
}