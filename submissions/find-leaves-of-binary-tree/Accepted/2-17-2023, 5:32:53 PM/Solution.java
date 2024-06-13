// https://leetcode.com/problems/find-leaves-of-binary-tree

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
            return res;
        
        if(root.left==null && root.right==null){
            res.add(new ArrayList<>());
            res.get(0).add(root.val);
            return res;
        }
        
        
        while(root.left!=null || root.right!=null){
            res.add(new ArrayList<>());
            helper(null, true, root, res);
        }
        
        res.add(new ArrayList<>());
        res.get(res.size()-1).add(root.val);
        
        
        return res;

        
        
        
    }
    
    private void helper(TreeNode parent, boolean left,  TreeNode node, List<List<Integer>> res){
        
        if(node==null)
            return;
        
        if(node.left==null && node.right==null){
            
            res.get(res.size()-1).add(node.val);
            if(left)
                parent.left=null;
            else 
                parent.right=null;
        }
        helper(node, true,  node.left, res);
        helper(node, false,  node.right, res);
        
        
        
    }
}