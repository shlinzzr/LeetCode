// https://leetcode.com/problems/delete-leaves-with-a-given-value

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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        if(root==null || (root.val==target && root.left==null && root.right==null))
            return null;
        
        helper(null, true, root, target);
        
        return root;
    }
    
    
    private void helper(TreeNode parent, boolean left, TreeNode node, int target){
        
        if(node==null)
            return;
        
        if(node.val==target && node.left==null && node.right==null){
            
            if(left){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }
        
        helper(node, true, node.left, target);
        helper(node, false, node.right, target);
    }
}