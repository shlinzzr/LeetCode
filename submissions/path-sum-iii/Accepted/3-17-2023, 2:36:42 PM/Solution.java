// https://leetcode.com/problems/path-sum-iii

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
    
    int cnt=0;
    public int pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum,  new ArrayList<>());
        
        return cnt;
        
    }
    
    private void helper(TreeNode root, int targetSum, List<Integer> list){
        
        if(root==null)
            return;
        
        list.add(root.val);
        long sum=0;
        
        for(int i=list.size()-1; i>=0; i--){
            sum+=list.get(i);
            if(sum==targetSum)
                cnt++;
        }
            
        helper(root.left, targetSum, list);
        helper(root.right, targetSum, list);
        
        
        list.remove(list.size()-1);
    }
    
}