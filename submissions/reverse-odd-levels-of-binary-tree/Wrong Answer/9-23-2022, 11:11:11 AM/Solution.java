// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree

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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)
            return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if(left!=null && right!=null){
            int tmp = left.val;
            left.val= right.val;
            right.val=tmp;
            
            reverseOddLevels(left.left);
            reverseOddLevels(left.right);
            reverseOddLevels(right.right);
            reverseOddLevels(right.left);
        }
        
        
        return root;
        
        
    }
}