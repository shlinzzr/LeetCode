// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence

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
    public int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        
        int     left = longestConsecutive(root.left);
        int     right = longestConsecutive(root.right);
        
        if(root.left==null || (root.left!=null && root.val+1==root.left.val))
            left+=1;
        if(root.right==null || (root.right!=null && root.val+1==root.right.val)){
            right+=1;
        }
        
        // System.out.println("root.val="+root.val+ " lfet="+left + " right="+right + " res="+ (Math.max(left, right)+1));
        
        return Math.max(left, right);        
    }
}