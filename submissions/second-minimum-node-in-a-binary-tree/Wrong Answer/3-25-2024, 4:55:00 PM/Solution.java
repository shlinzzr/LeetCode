// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree

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
    int min1=26;
    int min2=26;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);

        System.out.println(min1 + " " + min2);
        return min2==26? -1 : min2;
    }

    private void helper(TreeNode node){

        if(node==null) return ;

        if(node.val<min1){
            min2=min1;
            min1 = node.val;
        }else if(node.val<min2 && node.val!=min1){
            min2 = node.val;

        }

        helper(node.left);
        helper(node.right);

    }
}