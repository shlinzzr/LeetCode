// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 1);
        return res;
    }
    
    private void helper(List<Integer> res , TreeNode root, int lv){
        
        if(root==null)
            return;
        
        if(res.size()<lv){
            res.add(root.val);    
        }
        
        helper(res, root.right, lv+1);    
        helper(res, root.left, lv+1);    
    }
}
