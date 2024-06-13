// https://leetcode.com/problems/subtree-of-another-tree

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null) return false;

        if(isSameTree(root, subRoot)) return true;
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        if(left || right ) return true;

        return false;
        
    }

    private boolean isSameTree(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;

        if(a.val!=b.val) return false;
        boolean left = isSameTree(a.left, b.left);
        boolean right = isSameTree(a.right, b.right);
        return left && right;

    }
}