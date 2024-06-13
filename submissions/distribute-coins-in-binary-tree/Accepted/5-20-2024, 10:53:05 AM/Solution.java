// https://leetcode.com/problems/distribute-coins-in-binary-tree

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
    int numMov;
    public int distributeCoins(TreeNode root) {
        numMov = 0;
        givenCoin(root);
        return numMov;
    }

    public int givenCoin(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = givenCoin(node.left);
        int right = givenCoin(node.right);
        numMov += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}