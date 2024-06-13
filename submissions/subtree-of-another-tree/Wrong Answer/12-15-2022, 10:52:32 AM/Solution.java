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
     
        if(root==null && subRoot==null)
            return true;
        
        if(root==null || subRoot==null)
            return false;
        
        boolean res = true;
        if(root.val==subRoot.val){
            return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
        }
        
        
        res = res && (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
        
        return res;
        
    }
}