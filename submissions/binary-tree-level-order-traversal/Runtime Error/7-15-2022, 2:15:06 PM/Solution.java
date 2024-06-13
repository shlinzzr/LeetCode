// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level =1;
        
        levelOrder(root, level, res);
        return res;
        
    }
    
    private void levelOrder(TreeNode root, int level, List<List<Integer>> res){
        
        if(res.size()<level)
            res.add(new ArrayList<Integer>());
        
        res.get(level-1).add(root.val);
        if(root.left!=null)
            levelOrder(root.left, level+1, res);
        
        if(root.right!=null)
            levelOrder(root.right, level+1, res);
        
        
            
        
        
    }
}