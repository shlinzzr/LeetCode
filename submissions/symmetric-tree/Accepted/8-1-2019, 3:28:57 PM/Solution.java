// https://leetcode.com/problems/symmetric-tree

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
    public boolean isSymmetric(TreeNode root) {
       return root==null || check(root.left, root.right);
    }
    
    
     public boolean check(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }else if(left!=null && right!=null){
            return left.val==right.val && check(left.left, right.right) && check(left.right, right.left);
        }
        
        return false;
    }
}