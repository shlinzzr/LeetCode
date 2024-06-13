// https://leetcode.com/problems/diameter-of-binary-tree

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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);

        return max;
    }

    private int getDepth(TreeNode node){
        if(node==null) return 0;

        int left = getDepth(node.left);
        int right = getDepth(node.right);
        max = Math.max(max, left+right);
        return Math.max(left, right) +1;
    }
}