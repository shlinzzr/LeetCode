// https://leetcode.com/problems/maximum-binary-tree

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;       

        return helper(nums, 0, len-1);

    }

    private TreeNode helper(int[] nums, int st, int ed){
        
        if(st>ed)
            return null;

        if(st==ed){
            return  new TreeNode(nums[st]);
        }

        int len = nums.length;

        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=st; i<=ed; i++){
            if(nums[i]>max){
                idx =i;
                max = nums[i];
            }
        }

        TreeNode node = new TreeNode(max);
        TreeNode left = helper(nums, st, idx-1);
        TreeNode right = helper(nums, idx+1, ed);
        node.left= left;
        node.right=right;

        return node;

    }
}