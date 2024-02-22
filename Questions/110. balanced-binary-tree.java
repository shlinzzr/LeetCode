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

    boolean flag = true;
    public boolean isBalanced(TreeNode root) {

        getH(root);

        return flag;
        
    }

    private int getH(TreeNode root){

        if(root==null) return 0;

        int left = getH(root.left);
        int right = getH(root.right);

        if(Math.abs(left- right)>1) flag = false;

        return 1+Math.max(left, right);

    }
}