// https://leetcode.com/problems/distribute-coins-in-binary-tree

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
    public int distributeCoins(TreeNode root) {

        if(root==null) return 0;
        if(root.left==null && root.right==null){
            if(root.val==1) 
                return 0;
            else if (root.val==0) 
                return 1;
            else 
                return root.val-1;
        }
        
        return (distributeCoins(root.left)+ distributeCoins(root.right) );
    }
}