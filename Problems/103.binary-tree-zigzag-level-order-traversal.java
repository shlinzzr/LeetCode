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
        List<List<Integer>> res = new ArrayList<>();
        
        helper(root, res, 0);
        
        return res;
        
    }
    
    private void helper(TreeNode node, List<List<Integer>> res, int lv){
        
        if(node==null) return;
        
        if(res.size()<lv+1){
            res.add(new ArrayList<>());
        }
        
        if(lv%2==0)
            res.get(lv).add(node.val);
        else
            res.get(lv).add(0, node.val);
        
        helper(node.left, res, lv+1);
        helper(node.right, res, lv+1);
        
    }
    
    
}