// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree

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

    public int averageOfSubtree(TreeNode root) {
        
        if(root==null)
            return 0;
        
        if(root.val==getSum(root)/getCnt(root))
            res++;
        
        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return res;


    }

    private int getSum(TreeNode node){
        if(node==null)
            return 0;

        return node.val + getSum(node.left) + getSum(node.right);
    }


    private int getCnt(TreeNode node){
        if(node==null)
            return 0;
        
        if(node.left==null && node.right==null){
            return 1;
        }

        return 1 + getCnt(node.left) + getCnt(node.right);
    }
}