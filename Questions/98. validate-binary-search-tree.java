// https://leetcode.com/problems/validate-binary-search-tree

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

    boolean flag = true;
    public boolean isValidBST(TreeNode root) {

        if(root==null) return true;

        if(root.left!=null && root.left.val>=root.val) return false;
        if(root.right!=null && root.right.val<=root.val) return false;

        boolean left = helper(root.left, null, root.val);
        boolean right = helper(root.right, root.val, null);

        return left && right;

        
        
    }

    private boolean helper(TreeNode root, Integer lowerBound, Integer higherBound){

        if(root==null) return true;

        if(root.left!=null && root.left.val>=root.val) return false;
        if(root.right!=null && root.right.val<=root.val) return false;  

        if(lowerBound!=null && root.left!=null && root.left.val<=lowerBound) return false;
        if(higherBound!=null && root.right!=null && root.right.val>=higherBound) return false;  

        boolean left = helper(root.left, lowerBound, root.val);
        boolean right = helper(root.right, root.val, higherBound);


        return left && right;


    }
}