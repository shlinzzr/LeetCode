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
        
        
        helper(res, 0, root);
        
        return res;
        
    }
    
    private void helper(List<List<Integer>> res, int level, TreeNode root){
        if(root==null)
            return; 
        
        if(res.size()<level+1){
            res.add(new ArrayList<>());
        }
        
        List<Integer> list = res.get(level);
        
        if(level%2==0){
            list.add(root.val);
        }else{
            list.add(0, root.val);
        }
        
        
        helper(res,  level+1, root.left);
        helper(res,  level+1, root.right);        
        
        
        
        
    }
    
}
