// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

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
    public void flatten(TreeNode root) {

        preorder(root);
        
    }

    private TreeNode preorder(TreeNode node){
        if(node==null) return null;

        TreeNode leftTail = preorder(node.left);
        TreeNode rightTail = preorder(node.right);


        if(leftTail!=null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
            

        if(rightTail!=null) return rightTail;
        else if(leftTail!=null) return leftTail;
        else return node;
    }
}