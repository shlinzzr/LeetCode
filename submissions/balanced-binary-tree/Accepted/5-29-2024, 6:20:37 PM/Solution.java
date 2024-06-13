// https://leetcode.com/problems/balanced-binary-tree

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
    public boolean isBalanced(TreeNode root) {
        return getDepth(root)>-1;
    }

    private int getDepth(TreeNode node){
        if(node==null) return 0;

        int left= getDepth(node.left);
        int right = getDepth(node.right);

        if(Math.abs(left-right)>1) return -1;
        if(left==-1 || right==-1) return -1;

        return Math.max(left, right) +1;
    }
}