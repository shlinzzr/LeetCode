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
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        
        
        helper(res, list, root, targetSum);
        return res;
    }
    
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode curr, int targetSum){
        
        if(curr.left==null && curr.right==null){
           int sum=0;
            for(int v: list){
                sum+=v;
            }
            if(sum==targetSum)
                res.add(new ArrayList<>(list));
        }
        
        
        
        if(curr.left!=null){
            
            list.add(curr.left.val);
            helper(res, list, curr.left, targetSum);
            list.remove(list.size()-1);
        }
        
        if(curr.right!=null){
            list.add(curr.right.val);
            helper(res, list, curr.right, targetSum);
            list.remove(list.size()-1);
        }
            
    }
}