// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

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

    int diff = 0; 
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        helper(root, root);
        return diff;
    }

    private void helper(TreeNode ans, TreeNode cur){
        if(cur==null || ans==null) return;

        diff = Math.max(diff, Math.abs(ans.val-cur.val));

        helper(ans, cur.left);
        helper(ans, cur.right);

        if(ans==cur){
            helper(ans.left, cur.left);
            helper(ans.right, cur.right);
        }

    }



    // private int getMin(TreeNode node){
    //     if(node==null) return Integer.MAX_VALUE;

    //     int left = getMin(node.left);
    //     int right = getMin(node.right);
    //     return Math.min(left, right);
    // }

  
}