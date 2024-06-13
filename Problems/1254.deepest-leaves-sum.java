// https://leetcode.com/problems/deepest-leaves-sum

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
    int sum = 0;
    int max = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return  sum ;
    }
    
    private void helper(TreeNode node, int lv){
        
        if(node==null) return ;
        
        if(node.left==null && node.right==null){
            if(lv==max){
                sum+=node.val;
            }else if(lv>max){
                sum = node.val;
                max = lv;
            }
        }
        
        helper(node.left, lv+1);
        helper(node.right, lv+1);
    }
}