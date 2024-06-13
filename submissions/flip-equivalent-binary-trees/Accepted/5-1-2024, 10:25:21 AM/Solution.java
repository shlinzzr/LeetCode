// https://leetcode.com/problems/flip-equivalent-binary-trees

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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null) return false;
        else if(root1.val != root2.val) return false;


        boolean chg1 = flipEquiv(root1.left, root2.right);
        boolean chg2 = flipEquiv(root1.right, root2.left);

        boolean same1 = flipEquiv(root1.left, root2.left);
        boolean same2 = flipEquiv(root1.right, root2.right);

        return (chg1 && chg2) || (same1 && same2);
    }
}