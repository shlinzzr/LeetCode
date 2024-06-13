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

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(left, right), leftDepth+rightDepth);

    }

    private int getDepth(TreeNode node){
        if(node==null)
            return 0;

        return Math.max(getDepth(node.left), getDepth(node.right))+1;
    }
}