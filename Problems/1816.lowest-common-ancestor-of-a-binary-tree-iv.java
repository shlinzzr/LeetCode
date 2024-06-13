// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        Set<Integer> set = new HashSet<>();
        for(TreeNode nd: nodes){
            set.add(nd.val);
        }

        return helper(root, set);
    }

    private TreeNode helper(TreeNode node, Set<Integer> set){
        if(node==null) return null;

        for(int v: set){
            if(node.val==v) return node;
        }

        TreeNode left = helper(node.left, set);
        TreeNode right = helper(node.right, set);

        if(left!=null && right!=null) return node;

        return left!=null ? left : right;

    }
}