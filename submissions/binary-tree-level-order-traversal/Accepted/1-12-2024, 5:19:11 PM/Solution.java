// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(root, res, 0);
        return res;
    }
    
    
    private void helper(TreeNode root, List<List<Integer>>res, int lv){
        
        if(root==null) return;
        
        if(res.size()<lv+1){
            res.add(new ArrayList<>());
        }
        
        res.get(lv).add(root.val);
        
        helper(root.left, res, lv+1);
        helper(root.right, res, lv+1);
        
    }
}