// https://leetcode.com/problems/path-sum-ii

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
            return res;
        
        List<Integer> curr = new ArrayList<>();
        
        helper(root, curr, res, targetSum);
        
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> curr, List<List<Integer>> res, int target){
        
        if(root==null)
            return;
        
        curr.add(root.val);
        target-=root.val;
        
        if(root.left==null && root.right==null && target==0){
            res.add(new ArrayList<>(curr));
        }
        
        if(root.left!=null){
            helper(root.left, curr, res, target);    
        }
        
        if(root.right!=null){
            helper(root.right, curr, res, target);    
        }
        
        target+=root.val;
        curr.remove(curr.size()-1);
        
        
    }
}