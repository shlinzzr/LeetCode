// https://leetcode.com/problems/longest-univalue-path

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
    public int longestUnivaluePath(TreeNode root) {
        
        if(root==null)
            return 0;
            
        dfs(root);
        return max-1;
    }

    private int dfs(TreeNode node){
        if(node==null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        left = node.left!=null && node.left.val==node.val ? left: 0;
        right = node.right!=null && node.right.val==node.val ? right: 0;

        max = Math.max(max, 1+left+right);



        return Math.max(left, right) + 1;

    }


}