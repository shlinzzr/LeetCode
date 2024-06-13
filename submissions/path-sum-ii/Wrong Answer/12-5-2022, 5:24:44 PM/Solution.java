// https://leetcode.com/problems/path-sum-ii

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
            return res;
            
        List<Integer> list =new ArrayList<>();
        list.add(root.val);
        
        helper(res, list, root, targetSum, root.val);
        
        return res;
    }
    
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int targetSum, int curr){
        
        if(root==null)
            return;
        
        if(curr==targetSum){
            res.add(new ArrayList<>(list));
        }
        
        if(root.left!=null){
            list.add(root.left.val);
            helper(res, list, root.left, targetSum, curr+root.left.val);
            list.remove(list.size()-1);
        }
        
        if(root.right!=null ){
            list.add(root.right.val);
            helper(res, list, root.right, targetSum, curr+root.right.val);
            list.remove(list.size()-1);
        }
        
        
    }
}