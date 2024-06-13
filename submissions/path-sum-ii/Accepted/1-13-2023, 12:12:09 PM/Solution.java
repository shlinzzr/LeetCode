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
        
        helper(res, root, targetSum, new ArrayList<>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode curr, int targetSum, List<Integer> list){
        
        if(curr.left==null && curr.right==null){
            int sum=0;
            for(int i : list)
                sum+=i;
            System.out.println(curr.val + " " + sum);
            if(curr.val+ sum==targetSum){
                list.add(curr.val);
                res.add(new ArrayList<>(list)); 
                list.remove(list.size()-1);
            }
        }
        
        list.add(curr.val);
        
        if(curr.left!=null){
            helper(res, curr.left, targetSum, list);
        }
        if(curr.right!=null){
            helper(res, curr.right, targetSum, list);
        }
        
        list.remove(list.size()-1);
    }
}