// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii

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

    boolean pFound=false, qFound=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        find(root, p, q);

        if(pFound && qFound){
            return helper(root, p, q);
        }

        return null;
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){

        if(node==null || p==null || q==null) return null;

        if(node.val==p.val || node.val==q.val) return node;

        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);

        if(left!=null && right!=null) return node;


        return left!=null ? left : right;
    }

    private void find(TreeNode node ,TreeNode p, TreeNode q){
        if(node==null) return;

        if(node.val==p.val) pFound=true;
        if(node.val==q.val) qFound=true;

        if(pFound && qFound) return;
        find(node.left, p, q);
        find(node.right, p, q);
    }
}