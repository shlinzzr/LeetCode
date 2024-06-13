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
        helper(root, res, 0);
        
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res, int currDepth){

        if(root==null) 
            return;
        
        if(currDepth==res.size())
            res.add(root.val);
        
        helper(root.right, res ,currDepth+1);
        helper(root.left, res ,currDepth+1);
        
    }
    
}