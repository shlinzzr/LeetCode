// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>>  res = new ArrayList<>();
        helper(root, 1, res);
        return res;
        
        
    }
    
    private void helper(TreeNode root, int level, List<List<Integer>> res){
        if(root==null)
            return;
        
        if(res.size()<level){
            res.add(new ArrayList<>());
        }
        
        
        helper(root.left, level+1, res);
        
        if(level%2==1)
            res.get(level-1).add(root.val);
        else 
            res.get(level-1).add(0, root.val);
        
        helper(root.right, level+1, res);
    }
    
}