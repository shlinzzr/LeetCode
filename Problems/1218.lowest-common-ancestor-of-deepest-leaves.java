// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves

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

    int max = 0;
    List<TreeNode> leaves = new ArrayList<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {


        getDepth(root, 0);


        return helper(root);
    }

    private TreeNode helper(TreeNode node){

        if(node==null) return null;

        for(TreeNode leaf : leaves){
            if(leaf.val==node.val) return node;
        }

        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);

        if(left!=null && right!=null) return node;

        return left!=null ? left : right; 
    }

    private void getDepth(TreeNode node, int d){

        if(node==null) return;

        if(node.left==null && node.right==null){
            if(d>max){
                max = d;
                leaves = new ArrayList<>();
            }
            
            if(d>=max){
                leaves.add(node);
            }
        }

        getDepth(node.left, d+1);
        getDepth(node.right, d+1);

    }
}