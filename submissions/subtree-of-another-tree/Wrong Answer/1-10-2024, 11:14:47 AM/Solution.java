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

        if(subRoot==null && root==null) return true;

        if(subRoot!=null && subRoot.left==null && subRoot.right==null 
        && root!=null && (root.left!=null || root.right!=null))
             return false;

        if(root==null) return false;

        // if(root.val!=subRoot.val) return false;

        if(root.val==subRoot.val){
            return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) ;
    }
}