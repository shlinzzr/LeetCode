// https://leetcode.com/problems/maximum-binary-tree-ii

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }else if(root.val<val){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }else if(root.val>val){
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }

        return null;

    }
}