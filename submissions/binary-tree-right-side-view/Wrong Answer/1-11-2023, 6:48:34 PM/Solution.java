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
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res , TreeNode root){
        
        if(root==null)
            return;
        
        res.add(root.val);
        
        if(root.right!=null){
            helper(res, root.right);    
        }else{
            helper(res, root.left);    
        }
    }
}
