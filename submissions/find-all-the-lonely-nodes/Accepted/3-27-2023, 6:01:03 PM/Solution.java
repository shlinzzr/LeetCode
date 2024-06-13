// https://leetcode.com/problems/find-all-the-lonely-nodes

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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        boolean isLonely = (root.left==null && root.right!=null) || (root.right==null && root.left!=null);
        
        helper(root, false, res);
        return res;
    }
    
    private void helper(TreeNode root, boolean single, List<Integer> res){
        if(root==null)
            return;
        
        if(single){
            res.add(root.val);
        }
        
        single = (root.left==null && root.right!=null) || (root.right==null && root.left!=null);
        
        helper(root.left, single, res);
        helper(root.right, single, res);
        
    }
}
