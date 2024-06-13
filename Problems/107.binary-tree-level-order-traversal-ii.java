// https://leetcode.com/problems/binary-tree-level-order-traversal-ii

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res  = new ArrayList<>();
        helper(res, root, 0);
        
        List<List<Integer>> rev = new ArrayList<>();
        for(int i=0; i<res.size(); i++){
            rev.add(new ArrayList<>(res.get(res.size()-i-1)));
        }
        
        return rev;
        
        
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int lv){
        
        if(root==null)
            return;
        
        if(res.size()<lv+1){
            res.add(new ArrayList<>());
        }
        
        res.get(lv).add(root.val);
        helper(res, root.left, lv+1);
        helper(res, root.right, lv+1);
        
    }
}