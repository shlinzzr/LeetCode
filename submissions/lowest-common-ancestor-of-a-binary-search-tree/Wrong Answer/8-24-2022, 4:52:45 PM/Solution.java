// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val<q.val)
            return root;
        
        if(root.val>q.val && root.val<p.val)
            return root;
        
        TreeNode res = null;
        if(root.val>p.val && root.val>q.val)
            res = lowestCommonAncestor(root.left,p,q);
        
        if(root.val<p.val && root.val<q.val)
            res = lowestCommonAncestor(root.right,p,q);
        
        return res;
        
    }
}