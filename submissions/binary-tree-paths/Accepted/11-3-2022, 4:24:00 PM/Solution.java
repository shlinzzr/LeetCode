// https://leetcode.com/problems/binary-tree-paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        helper(root, res, "");
        return res;
    }
    
    private void helper(TreeNode root, List<String> res, String curr){
        
        if(root==null)
            return;
        
        if(!curr.isEmpty())
            curr += "->";
        curr += root.val;
        
        if(root.left==null && root.right==null){
            res.add(curr);
            return;
        }
        
            helper(root.left, res , curr);
            helper(root.right, res , curr);
            
    }
}